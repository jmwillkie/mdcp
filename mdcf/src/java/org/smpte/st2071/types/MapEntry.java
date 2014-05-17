package org.smpte.st2071.types;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.smpte.st2071.identity.URI;

public class MapEntry implements Serializable, java.util.Map.Entry<String, Serializable>
{
    private static final long serialVersionUID = 201404251036L;

    protected Serializable value;
    
    protected String key;
    
    protected DATATYPE type;
    
    
    public MapEntry()
    {
        super();
    }
    
    
    public MapEntry(String key, Serializable value)
    {
        this();
        this.key = key;
        setValue(value);
    }


    public Serializable getValue()
    {
        return value;
    }


    public Serializable setValue(Serializable value)
    {
        if (value != null)
        {
            if (value instanceof String)
            {
                type = DATATYPE.STRING;
                this.value = value.toString();
            } else if (value instanceof Boolean)
            {
                type = DATATYPE.BOOLEAN;
                this.value = (Boolean) value;
            } else if (value instanceof Date)
            {
                type = DATATYPE.DATETIME;
                this.value = (Date) value;
            } else if (value instanceof Calendar)
            {
                type = DATATYPE.DATETIME;
                this.value = ((Calendar) value).getTime();
            } else if (value instanceof byte[])
            {
                type = DATATYPE.BLOB;
                this.value = (byte[]) value;
            } else if (value instanceof short[])
            {
                type = DATATYPE.BLOB;
                int pos = 0;
                short[] in = (short[]) value;
                byte[] blob = new byte[in.length * 2];
                for (int i = 0; i < in.length; i++)
                {
                    blob[pos++] = (byte) (in[i] & 0x0FF);
                    blob[pos++] = (byte) ((in[i] >> 8) & 0x0FF);
                }
                this.value = blob;
            } else if (value instanceof int[])
            {
                type = DATATYPE.BLOB;
                int pos = 0;
                short[] in = (short[]) value;
                byte[] blob = new byte[in.length * 4];
                for (int i = 0; i < in.length; i++)
                {
                    blob[pos++] = (byte) (in[i] & 0x0FF);
                    blob[pos++] = (byte) ((in[i] >> 8) & 0x0FF);
                    blob[pos++] = (byte) ((in[i] >> 16) & 0x0FF);
                    blob[pos++] = (byte) ((in[i] >> 24) & 0x0FF);
                }
                this.value = blob;
            } else if (value instanceof long[])
            {
                type = DATATYPE.BLOB;
                int pos = 0;
                short[] in = (short[]) value;
                byte[] blob = new byte[in.length * 8];
                for (int i = 0; i < in.length; i++)
                {
                    blob[pos++] = (byte) (in[i] & 0x0FF);
                    blob[pos++] = (byte) ((in[i] >> 8) & 0x0FF);
                    blob[pos++] = (byte) ((in[i] >> 16) & 0x0FF);
                    blob[pos++] = (byte) ((in[i] >> 24) & 0x0FF);
                    blob[pos++] = (byte) ((in[i] >> 32) & 0x0FF);
                    blob[pos++] = (byte) ((in[i] >> 40) & 0x0FF);
                    blob[pos++] = (byte) ((in[i] >> 48) & 0x0FF);
                    blob[pos++] = (byte) ((in[i] >> 56) & 0x0FF);
                }
                this.value = blob;
            } else if (value instanceof Float)
            {
                type = DATATYPE.FLOAT;
                this.value = new Double(((Float) value).doubleValue());
            } else if (value instanceof Double)
            {
                type = DATATYPE.FLOAT;
                this.value = (Double) value;
            } else if (value instanceof Integer)
            {
                type = DATATYPE.INTEGER;
                this.value = (Integer) value;
            } else if (value instanceof URI)
            {
                type = DATATYPE.URI;
                this.value = (URI) value;
            } else if (value instanceof java.net.URI)
            {
                type = DATATYPE.URI;
                try
                {
                    this.value = new URI(value.toString());
                } catch (ParseException e)
                {
                    e.printStackTrace(System.err);
                }
            } else if (value instanceof Map)
            {
                type = DATATYPE.MAP;
                this.value = (Map) value;
            } else
            {
                type = DATATYPE.STRING;
                this.value = null;
                System.err.println("Error setting value for " + getClass().getName() + " - specified value [" + value.getClass().getName() + "] = \"" + value + "\" is not understood.");
            }
        } else
        {
            type = DATATYPE.STRING;
            this.value = null;
        }
        
        return this.value;
    }


    public String getKey()
    {
        return key;
    }


    public void setKey(String key)
    {
        this.key = key;
    }


    public DATATYPE getType()
    {
        return type;
    }
}
