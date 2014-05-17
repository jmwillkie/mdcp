package org.smpte.st2071.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class Map implements Serializable, java.util.Map<String, Serializable>
{
    private static final long serialVersionUID = 201404251036L;
    
    protected Set<MapEntry> entries = new LinkedHashSet<MapEntry>();
    
    private transient WeakHashMap<String, MapEntry> index = new WeakHashMap<String, MapEntry>();
    
    
    public Set<String> keySet()
    {
        Set<String> results = new LinkedHashSet<String>();
        for (MapEntry entry : entries)
        {
            results.add(entry.getKey());
        }
        return results;
    }
    
    
    public DATATYPE getType(String key)
    {
        MapEntry entry = getEntry(key);
        if (entry != null)
        {
            return entry.getType();
        } else
        {
            return null;
        }
    }
    
    
    @Override
    public Serializable get(Object key)
    {
        MapEntry entry = getEntry(key.toString());
        if (entry != null)
        {
            return entry.getValue();
        } else
        {
            return null;
        }
    }
    
    
    @Override
    public Serializable put(String key, Serializable value)
    {
        Serializable oldValue = null;
        MapEntry newEntry = newMapEntry(key, value);
        
        synchronized (entries)
        {
            MapEntry oldEntry = getEntry(key.toString());
            if (oldEntry != null)
            {
                oldValue = oldEntry.getValue();
            }
            
            entries.add(newEntry);
            index.put(key, newEntry);
            return oldValue;
        }
    }


    protected MapEntry newMapEntry(String key, Serializable value)
    {
        return new MapEntry(key, value);
    }


    private MapEntry getEntry(String key)
    {
        if (key == null)
        {
            return null;
        }
        
        MapEntry indexedEntry = index.get(key);
        
        if (indexedEntry != null)
        {
            return indexedEntry;
        } else if (index.containsKey(key))
        {
            return null;
        } else
        {
            synchronized (entries)
            {
                for (MapEntry entry : entries)
                {
                    index.put(entry.getKey(), entry);
                    if (entry.key != null && (entry.key == key || entry.key.equals(key)))
                    {
                        indexedEntry = entry;
                    }
                }
                
                if (indexedEntry == null)
                {
                    index.put(key, null);
                }
            }
        }
        return indexedEntry;
    }


    @Override
    public int size()
    {
        synchronized (entries)
        {
            return entries.size();
        }
    }


    @Override
    public boolean isEmpty()
    {
        synchronized (entries)
        {
            return entries.isEmpty();
        }
    }


    @Override
    public boolean containsKey(Object key)
    {
        return get(key) != null;
    }


    @Override
    public boolean containsValue(Object value)
    {
        synchronized (entries)
        {
            for (MapEntry entry : entries)
            {
                if (entry.value == value || (entry.value != null && entry.value.equals(value)))
                {
                    return true;
                }
            }
        }
        
        return false;
    }


    @Override
    public Serializable remove(Object key)
    {
        if (key == null)
        {
            return null;
        }
        
        synchronized (entries)
        {
            for (MapEntry entry : entries)
            {
                if (entry.key == key || (entry.key != null && entry.key.equals(key)))
                {
                    return entry.value;
                }
            }
        }
        
        return null;
    }


    @Override
    public void putAll(java.util.Map<? extends String, ? extends Serializable> map)
    {
        synchronized (entries)
        {
            for (java.util.Map.Entry<? extends String, ? extends Serializable> entry : map.entrySet())
            {
                put(entry.getKey(), entry.getValue());
            }
        }
    }


    @Override
    public void clear()
    {
        synchronized (entries)
        {
            entries.clear();
            index.clear();
        }        
    }


    @Override
    public Collection<Serializable> values()
    {
        List<Serializable> values = new ArrayList<Serializable>();
        synchronized (entries)
        {
            for (MapEntry entry : entries)
            {
                values.add(entry.getValue());
            }
        }
        return values;
    }


    @Override
    public Set<java.util.Map.Entry<String, Serializable>> entrySet()
    {
        Set<java.util.Map.Entry<String, Serializable>> values = new LinkedHashSet<java.util.Map.Entry<String, Serializable>>();
        synchronized (entries)
        {
            for (MapEntry entry : entries)
            {
                values.add(entry);
            }
        }
        return values;
    }


    @Override
    public Serializable getOrDefault(Object key, Serializable defaultValue)
    {
        Serializable result = get(key);
        return key == null ? defaultValue : result;
    }


    @Override
    public Serializable replace(String key, Serializable value)
    {
        Serializable result = null;
        synchronized (entries)
        {
            for (MapEntry entry : entries)
            {
                if (key.equals(entry.getKey()))
                {
                    if (entries.remove(entry))
                    {
                        result = entry.getValue();
                        put(entry.getKey(), entry.getValue());
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
