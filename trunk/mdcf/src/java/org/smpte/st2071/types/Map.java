package org.smpte.st2071.types;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.WeakHashMap;

public class Map implements Serializable
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
    
    
    public Serializable get(String key)
    {
        MapEntry entry = getEntry(key);
        if (entry != null)
        {
            return entry.getValue();
        } else
        {
            return null;
        }
    }
    
    
    public void put(String key, Serializable value)
    {
        MapEntry entry = new MapEntry(key, value);
        entries.add(entry);
        index.put(key, entry);
    }


    private MapEntry getEntry(String key)
    {
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
                    if (entry.key.equalsIgnoreCase(key))
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
}
