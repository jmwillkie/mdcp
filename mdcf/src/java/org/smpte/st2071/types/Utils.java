package org.smpte.st2071.types;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smpte_ra.schemas.st2071._2014.identity.URLs;
import org.smpte_ra.schemas.st2071._2014.types.DATATYPE;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;
import org.smpte_ra.schemas.st2071._2014.types.Key;
import org.smpte_ra.schemas.st2071._2014.types.Keys;

import sun.misc.BASE64Decoder;

public class Utils
{
    public static URL[] urlsToArray(URLs urls)
    {
        List<URL> results = new ArrayList<URL>();
        
        if (urls != null)
        {
            List<String> list = urls.getURL();
            if (list != null)
            {
                for (String url : list)
                {
                    try
                    {
                        results.add(new URL(url));
                    } catch (MalformedURLException e)
                    {
                        System.err.println(e.toString());
                        e.printStackTrace(System.err);
                    }
                }
            }
        }
        
        return results.toArray(new URL[results.size()]);
    }


    public static Date datetimeToDate(DateTime datetime)
    {
        if (datetime != null)
        {
            Calendar calendar = datetime.getDate().toGregorianCalendar();
            calendar.set(Calendar.HOUR_OF_DAY, datetime.getHour());
            calendar.set(Calendar.MINUTE, datetime.getMinute());
            calendar.set(Calendar.SECOND, datetime.getSecond());
            calendar.set(Calendar.MILLISECOND, datetime.getMicrosecond() * 1000);
            return calendar.getTime();
        } else
        {
            return new Date();
        }
    }


    public static Map<String, Object> mapToJavaMap(org.smpte_ra.schemas.st2071._2014.types.Map mdcMap)
    {
        BASE64Decoder base64 = new BASE64Decoder();
        Map<String, Object> map = new HashMap<String, Object>();
        
        if (mdcMap != null)
        {
            Keys keys = mdcMap.getKeys();
            if (keys != null)
            {
                for (Key key : keys.getKey())
                {
                    String id = key.getId();
                    DATATYPE type = key.getType();
                    String strValue = key.getValue();
                    Object value = null;
                    
                    try
                    {
                        switch (type)
                        {
                            case BOOLEAN :
                                value = strValue.equalsIgnoreCase("true") || strValue.equalsIgnoreCase("on") || strValue.equalsIgnoreCase("t");
                                break;
                            case BLOB :
                                value = base64.decodeBuffer(strValue);
                                break;
                            case DATETIME :
                                // TODO: Implement
                                break;
                            case FLOAT :
                                value = new Double(strValue);
                                break;
                            case INTEGER :
                                value = new Integer(strValue);
                                break;
                            case MAP :
                                // TODO: Parse XML String into MDC Map.
                                break;
                            case STRING :
                                value = strValue;
                                break;
                            case URI :
                                value = new URI(strValue);
                                break;
                        }
                    } catch (Exception e)
                    {
                        System.err.println("Map value \"" + key + "\" of type \"" + type + "\" could not be converted - " + e.toString());
                    }
                    
                    map.put(id, value);
                }
            }
        }
        
        return map;
    }
}
