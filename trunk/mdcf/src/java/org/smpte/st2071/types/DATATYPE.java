package org.smpte.st2071.types;

public enum DATATYPE
{
    BOOLEAN, STRING, INTEGER, FLOAT, DATETIME, URI, MAP, BLOB;
    
    public String value()
    {
        return name();
    }
    
    
    public static DATATYPE fromValue(String v)
    {
        return valueOf(v);
    }
}
