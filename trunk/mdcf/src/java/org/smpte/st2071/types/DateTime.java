package org.smpte.st2071.types;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * 
 * 
 * @author Steve Posick
 */
public class DateTime implements Serializable
{
    private static final long serialVersionUID = 201420021347L;

    protected static final BigInteger INT_1000 = BigInteger.valueOf(1000);
    
    protected static BigInteger startTimeNanoseconds;
    
    protected static long refNanoseconds;
    
    static
    {
        BigInteger bigInt = BigInteger.valueOf(System.currentTimeMillis());
        startTimeNanoseconds = bigInt.multiply(BigInteger.valueOf(1000000));
        refNanoseconds = System.nanoTime();
    }
    
    
    protected GregorianCalendar calendar;
    
    protected BigDecimal fractionalSecond;
    
    
    public DateTime()
    {
        this(new Date());
    }
    
    
    public DateTime(org.smpte_ra.schemas.st2071._2014.types.DateTime dateTime)
    {
        XMLGregorianCalendar cal = dateTime.getValue();
        this.calendar = cal.toGregorianCalendar();
        this.fractionalSecond = cal.getFractionalSecond();
    }
    
    
    public DateTime(XMLGregorianCalendar calendar)
    {
        this.calendar = calendar.toGregorianCalendar();
        this.fractionalSecond = calendar.getFractionalSecond();
    }


    public DateTime(Date date)
    {
        this.calendar = new GregorianCalendar();
        this.calendar.setTime(date);
        this.fractionalSecond = new BigDecimal((double) ((double) calendar.get(Calendar.MILLISECOND) / (double) 1000));
    }


    public DateTime(GregorianCalendar calendar)
    {
        this.calendar = new GregorianCalendar();
        this.fractionalSecond = new BigDecimal((double) ((double) calendar.get(Calendar.MILLISECOND) / (double) 1000));
    }
    
    
    /**
     * Returns the year.  a value of 0 indicates the year 1 BCE.
     *  
     * @return The year
     */
    public int getYear()
    {
        return calendar.get(Calendar.YEAR);
    }


    /**
     * Returns the month of the year.
     *  
     * @return The month of the year
     */
    public int getMonth()
    {
        return calendar.get(Calendar.MONTH);
    }


    /**
     * Returns the day of the month.
     *  
     * @return The day of the month
     */
    public int getDay()
    {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * Returns the hour of the day.
     *  
     * @return The hour of the day
     */
    public int getHour()
    {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    
    
    /**
     * Returns the minutes within the hour.
     *  
     * @return The minutes within the hour
     */
    public int getMinute()
    {
        return calendar.get(Calendar.MINUTE);
    }
    
    
    /**
     * Returns the seconds.
     *  
     * @return The seconds
     */
    public int getSecond()
    {
        return calendar.get(Calendar.SECOND);
    }
    
    
    /**
     * Returns the microseconds fractional second information.
     *  
     * @return The microseconds fractional second information
     */
    public int getMicrosecond()
    {
        BigDecimal decimal = fractionalSecond;
        if (decimal != null)
        {
            decimal = decimal.setScale(6, RoundingMode.HALF_UP);
            BigInteger unscaled = decimal.unscaledValue();
            return unscaled.intValue();
        } else
        {
            return 0;
        }
    }
    
    
    /**
     * Returns the nanoseconds fractional second information.
     *  
     * @return The nanoseconds fractional second information
     */
    public int getNanosecond()
    {
        BigDecimal decimal = fractionalSecond;
        if (decimal != null)
        {
            decimal = decimal.setScale(9, RoundingMode.HALF_UP);
            BigInteger unscaled = decimal.unscaledValue();
            return unscaled.intValue();
        } else
        {
            return 0;
        }
    }
    
    
    /**
     * Returns the fractional second information.
     *  
     * @return The fractional second information
     */
    public BigDecimal getFractionalSecond()
    {
        return fractionalSecond;
    }
    
    
    /**
     * Returns the time zone offset in minutes.
     *  
     * @return The time zone offset in minutes
     */
    public int getTimezoneOffset()
    {
        return calendar.get(Calendar.ZONE_OFFSET) / 60000; // 60000 milliseconds in a minute
    }
    
    
    /**
     * Gets the current system time in microseconds. 
     * 
     * @return The current system time in microseconds
     */
    public static long currentTimeMicros()
    {
        BigInteger nanos = currentTimeNanos();
        return nanos.divide(INT_1000).longValue();
    }
    
    
    /**
     * Gets the current system time in nanoseconds. 
     * 
     * @return The current system time in nanoseconds
     */
    public static BigInteger currentTimeNanos()
    {
        long nanoSeconds = System.nanoTime() - refNanoseconds;
        return startTimeNanoseconds.add(BigInteger.valueOf(nanoSeconds));
    }
}
