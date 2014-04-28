package org.smpte.mdc4android.mdcf;

import java.io.Serializable;

import org.smpte.st2071.types.DATATYPE;

import android.os.Parcel;
import android.os.Parcelable;

public class MapEntry extends org.smpte.st2071.types.MapEntry implements Parcelable
{
    private static final long serialVersionUID = 201404251036L;
    
    public static final Parcelable.Creator<MapEntry> CREATOR = new Parcelable.Creator<MapEntry>() 
    {
        public MapEntry createFromParcel(Parcel in)
        {
            return new MapEntry(in);
        }
        
        
        public MapEntry[] newArray(int size)
        {
            return new MapEntry[size];
        }
    };
    
    
    public MapEntry()
    {
        super();
    }
    
    
    public MapEntry(String key, Serializable value)
    {
        super(key, value);
    }


    private MapEntry(Parcel in)
    {
        super.key = in.readString();
        super.type = DATATYPE.values()[in.readInt()];
        super.value = in.readSerializable();
    }


    @Override
    public int describeContents()
    {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(key);
        dest.writeInt(type.ordinal());
        dest.writeSerializable(value);
    }
}
