package org.smpte.mdc4android.mdcf;

import android.os.Parcel;
import android.os.Parcelable;

public class Capability implements Parcelable
{
    public static final Parcelable.Creator<Capability> CREATOR = new Parcelable.Creator<Capability>() 
    {
        public Capability createFromParcel(Parcel in)
        {
            return new Capability(in);
        }
        
        
        public Capability[] newArray(int size)
        {
            return new Capability[size];
        }
    };
    
    protected String ucn;
    
    protected Map attributes;
    
    protected String[] urls;
    

    private Capability(Parcel in) 
    {
        readFromParcel(in);
    }
    
    
    public Capability()
    {
        super();
    }
    
    
    public Capability(String ucn, Map attributes, String[] urls)
    {
        super();
        
        this.ucn = ucn;
        this.attributes = attributes;
        this.urls = urls;
    }
    

    public String getUCN()
    {
        return ucn;
    }


    public void setUcn(String ucn)
    {
        this.ucn = ucn;
    }


    public String[] getUrls()
    {
        return urls;
    }


    public void setUrls(String[] urls)
    {
        this.urls = urls;
    }


    public void addUrls(String[] urls)
    {
        String[] temp = this.urls;
        if (temp == null)
        {
            this.urls = urls;
        } else
        {
            String[] newUrls = new String[temp.length + urls.length];
            System.arraycopy(temp, 0, newUrls, 0, temp.length);
            System.arraycopy(urls, 0, newUrls, temp.length, urls.length);
            this.urls = newUrls;
        }
    }


    public Map getAttributes()
    {
        return attributes;
    }


    public void setAttributes(Map attributes)
    {
        this.attributes = attributes;
    }
    
    
    public String[] getKeys()
    {
        return attributes.keySet().toArray(new String[0]);
    }
    
    
    public Object get(String key)
    {
        return attributes.get(key);
    }


    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Capability)
        {
            Capability that = (Capability) o;
            return (this.ucn == null && that.ucn == null) || this.ucn.equals(that.ucn);
        } else if (o instanceof String)
        {
            return (this.ucn == null && o == null) || this.ucn.equals(o);
        }
        
        return false;
    }


    @Override
    public int hashCode()
    {
        return this.ucn == null ? 0 : this.ucn.hashCode();
    }


    @Override
    public int describeContents()
    {
        return 0;
    }
    
    
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(ucn);
        dest.writeParcelable(attributes, 0);
        dest.writeStringArray(urls);
    }
    
    
    public void readFromParcel(Parcel in)
    {
        ucn = in.readString();
        attributes = (Map) in.readParcelable(Map.class.getClassLoader());
        String[] urls = in.createStringArray();
        in.readStringArray(urls);
        this.urls = urls;
    }
}
