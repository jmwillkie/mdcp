package org.smpte.util;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;

/**
 * The ListenerSupport class implements a performant, thread safe, listener subsystem
 * that does not create temporary objects during the event dispatch process.  The order in which
 * listeners are registered determines the order by which the listeners are called during event 
 * dispatch.  A listener may halt the delivery of events to subsequent listeners by throwing a
 * StopDispatchException.
 * 
 * @author Steve Posick
 */
@SuppressWarnings("unchecked")
public class ListenerProcessor<T> implements Closeable
{
    public static interface ListenerProcessorListener
    {
        public <T> void listenerRegistered(Class<T> type, T listener);
        
        
        public <T> void listenerUnregistered(Class<T> type, T listener);
    }
    
    
    protected static class Dispatcher implements InvocationHandler
    {
        ListenerProcessor<?> processor;
        
        protected Dispatcher(ListenerProcessor<?> processor)
        {
            this.processor = processor;
        }
        

        public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable
        {
            Object[] tempListeners = processor.listeners;
        
            for (Object listener : tempListeners)
            {
                try
                {
                    method.invoke(listener, args);
                } catch (IllegalArgumentException e)
                {
                    System.err.println(e.getMessage());
                    e.printStackTrace(System.err);
                    throw e;
                } catch (IllegalAccessException e)
                {
                    System.err.println(e.getMessage());
                    e.printStackTrace(System.err);
                    throw e;
                } catch (InvocationTargetException e)
                {
                    if (e.getTargetException() instanceof StopDispatchException)
                    {
                        break;
                    } else
                    {
                        System.err.println(e.getTargetException().getMessage());
                        e.getTargetException().printStackTrace(System.err);
                        throw e.getTargetException();
                    }
                } catch (Exception e)
                {
                    System.err.println(e.getMessage());
                    e.printStackTrace(System.err);
                    throw e;
                }
            }
            
            return null;
        }
    }
    
    
    public static class StopDispatchException extends Exception
    {
        private static final long serialVersionUID = 201401211841L;

        public StopDispatchException()
        {
            super();
        }
    }
    
    private Class<T> iface;
    
    private Object[] listeners = new Object[0];

    private T dispatcher;

    private static List<ListenerProcessorListener> listenerProcessorListeners = new ArrayList<ListenerProcessorListener>();
    

    public ListenerProcessor(Class<T> iface)
    {
        this.iface = iface;
        if (!iface.isInterface())
        {
            throw new IllegalArgumentException("\"" + iface.getName() + "\" is not an interface.");
        }
    }
    
    
    public synchronized T registerListener(T listener)
    {
        // Make sure the listener is not null and that it implements the Interface
        if (listener != null && iface.isAssignableFrom(listener.getClass()))
        {
            // Check to ensure the listener does not exist
            for (int index = 0; index < listeners.length; index++)
            {
                if (listeners[index] == listener || listeners[index].equals(listener))
                {
                    // already registered
                    return (T) listeners[index];
                }
            }
            
            T[] temp = (T[]) Arrays.copyOf(listeners, listeners.length + 1);
            temp[temp.length - 1] = listener;
            this.listeners = temp;
            
            dispatchListenerRegistered(iface, listener);
            return listener;
        } else
        {
            return null;
        }
    }


    protected synchronized void dispatchListenerRegistered(Class<T> type, T listener)
    {
        for (ListenerProcessorListener processorListener : listenerProcessorListeners)
        {
            processorListener.listenerRegistered(type, listener);
        }
    }


    protected synchronized void dispatchListenerUnregistered(Class<T> type, T listener)
    {
        for (ListenerProcessorListener processorListener : listenerProcessorListeners)
        {
            processorListener.listenerUnregistered(type, listener);
        }
    }


    public synchronized T unregisterListener(T listener)
    {
        if (listener != null)
        {
            T[] temp = (T[]) Arrays.copyOf(listeners, listeners.length);
            
            // Find listener 
            for (int index = 0; index < temp.length; index++)
            {
                if (temp[index] == listener || temp[index].equals(listener))
                {
                    T foundListener = temp[index];
                    
                    // Found listener, delete it and shift remaining listeners back one position.
                    System.arraycopy(temp, index + 1, temp, index, temp.length - index - 1);
                    this.listeners = Arrays.copyOf(temp, temp.length - 1);
                    
                    dispatchListenerUnregistered(iface, foundListener);
                    return foundListener;
                }
            }
        }
        
        return null;
    }
    
    
    public boolean hasListeners()
    {
        return listeners != null && listeners.length > 0;
    }
    
    
    public T getDispatcher()
    {
        if (dispatcher == null)
        {
            dispatcher = (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{iface}, new Dispatcher(this));
        } 
        return dispatcher;
    }
    
    
    /**
     * Registers a Listener Processor Listener to receive events when new listeners are registered.
     * 
     * @param listener The Listener Processor Listener
     */
    public synchronized void registerListenerProcessorListener(ListenerProcessorListener listener)
    {
        if (!listenerProcessorListeners.contains(listener))
        {
            listenerProcessorListeners.add(listener);
        }
    }
    
    
    /**
     * Unregisters a Listener Processor Listener.
     * 
     * @param listener The Listener Processor Listener
     */
    public synchronized void unregisterListenerProcessorListener(ListenerProcessorListener listener)
    {
        listenerProcessorListeners.remove(listener);
    }


    protected Class<?>[] getAllInterfaces(Class<?> clazz)
    {
        LinkedHashSet<Class<?>> set = new LinkedHashSet<Class<?>>();
        Stack<Class<?>> stack = new Stack<Class<?>>();
        
        stack.push(clazz);
        
        if (clazz.isInterface())
        {
            set.add(clazz);
        }
        
        while (!stack.isEmpty())
        {
            Class<?> cls = stack.pop();
            Class<?>[] interfaces = cls.getInterfaces();
            if (interfaces != null && interfaces.length > 0)
            {
                for (Class<?> iface : interfaces)
                {
                    if (set.add(iface))
                    {
                        stack.push(iface);
                    }
                }
            }
            
            Class<?> superClass = cls.getSuperclass();
            if (superClass != null)
            {
                if (superClass.isInterface())
                {
                    set.add(superClass);
                }
                stack.push(superClass);
            }
        }
        
        return set.toArray(new Class[set.size()]);
    }


    public void close()
    throws IOException
    {
        if (listenerProcessorListeners != null)
        {
            listenerProcessorListeners.clear();
        }
        
        for (int i = 0; i < this.listeners.length; i++)
        {
            this.listeners[i] = null;
        }
        this.listeners = new Object[0];
    }
}
