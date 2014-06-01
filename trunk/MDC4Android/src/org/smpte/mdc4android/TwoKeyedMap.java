package org.smpte.mdc4android;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TwoKeyedMap<K1, K2, V> implements Serializable
{
    private static final long serialVersionUID = 201406011311L;
    

    private LinkedHashMap<K1, Map<K2, V>> map = new LinkedHashMap<K1, Map<K2, V>>();
    
    private int size = -1;
    
    public TwoKeyedMap()
    {
        super();
    }
    
    
    public TwoKeyedMap(TwoKeyedMap<K1, K2, V> map)
    {
        this();
        putAll(map);
    }


    public TwoKeyedMap(K1 key, Map<K2, V> map)
    {
        this();
        putAll(key, map);
    }
    
    
    public V put(K1 key1, K2 key2, V value)
    {
        synchronized (this.map)
        {
            size = -1;
            Map<K2, V> subMap = map.get(key1);
            if (subMap == null)
            {
                subMap = new LinkedHashMap<K2, V>();
                map.put(key1, subMap);
            }
        
            return subMap.put(key2, value);
        }
    }
    
    
    public Map<K2, V> get(K1 key1)
    {
        synchronized (this.map)
        {
            return map.get(key1);
        }
    }
    
    
    public V get(K1 key1, K2 key2)
    {
        synchronized (this.map)
        {
            Map<K2, V> subMap = map.get(key1);
            if (subMap != null)
            {
                return subMap.get(key2);
            }
        }
        
        return null;
    }
    
    
    public Set<K1> keySet()
    {
        synchronized (this.map)
        {
            return map.keySet();
        }
    }
    
    
    public Set<K2> keySet(K1 key1)
    {
        synchronized (this.map)
        {
            return map.get(key1).keySet();
        }
    }
    
    
    public boolean containsKey(K1 key1)
    {
        synchronized (this.map)
        {
            return map.containsKey(key1);
        }
    }
    
    
    public boolean containsKey(K1 key1, K2 key2)
    {
        synchronized (this.map)
        {
            Map<K2, V> subMap = map.get(key1);
            if (subMap != null)
            {
                return subMap.containsKey(key2);
            }
        }
        
        return false;
    }
    
    
    public Set<Entry<K1, Map<K2, V>>> entrySet()
    {
        synchronized (this.map)
        {
            return map.entrySet();
        }
    }
    
    
    public void putAll(TwoKeyedMap<K1, K2, V> map)
    {
        if (map != null)
        {
            synchronized (this.map)
            {
                size = -1;
                for (Entry<K1, Map<K2, V>> entry : map.entrySet())
                {
                    for (Entry<K2, V> subEntry : entry.getValue().entrySet())
                    {
                        put(entry.getKey(), subEntry.getKey(), subEntry.getValue());
                    }
                }
            }
        }
    }


    public void putAll(K1 key, Map<K2, V> map)
    {
        if (map != null)
        {
            synchronized (this.map)
            {
                size = -1;
                for (Entry<K2, V> subEntry : map.entrySet())
                {
                    put(key, subEntry.getKey(), subEntry.getValue());
                }
            }
        }
    }


    public int size()
    {
        if (this.size < 0)
        {
            synchronized (this.map)
            {
                int size = 0;
                for (Entry<K1, Map<K2, V>> entry :  entrySet())
                {
                    Map<K2, V> map = entry.getValue();
                    size += map.size();
                }
                
                this.size = size;
            }
        }
        
        return this.size;
    }


    public Map<K2, V> remove(K1 key1)
    {
        return map.remove(key1);
    }


    public V remove(K1 key1, K2 key2)
    {
        synchronized (this.map)
        {
            Map<K2, V> subMap = map.get(key1);
            if (subMap != null)
            {
                V result = subMap.remove(key2);
                if (subMap.size() == 0)
                {
                    map.remove(key1);
                }
                return result;
            }
        }
        
        return null;
    }
}
