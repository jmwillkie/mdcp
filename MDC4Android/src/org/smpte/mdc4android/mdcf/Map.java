package org.smpte.mdc4android.mdcf;

import java.io.Serializable;
import java.util.Arrays;

import android.os.Parcel;
import android.os.Parcelable;

public class Map extends org.smpte.st2071.types.Map implements Parcelable
{
    private static final long serialVersionUID = 201404251036L;

    public static final Parcelable.Creator<Map> CREATOR = new Parcelable.Creator<Map>() 
    {
        public Map createFromParcel(Parcel in)
        {
            return new Map(in);
        }
        
        
        public Map[] newArray(int size)
        {
            return new Map[size];
        }
    };
    
    
    public Map()
    {
        super();
    }
    
    
    private Map(Parcel in)
    {
        this();
        super.entries.clear();
        super.entries.addAll(Arrays.asList((MapEntry[]) in.readParcelableArray(MapEntry.class.getClassLoader())));
    }


    protected MapEntry newMapEntry(String key, Serializable value)
    {
        return new MapEntry(key, value);
    }
    

    @Override
    public int describeContents()
    {
        return 0;
    }
    

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        synchronized (super.entries)
        {
            dest.writeParcelableArray(super.entries.toArray(new MapEntry[entries.size()]), 0);
        }
    }
}
