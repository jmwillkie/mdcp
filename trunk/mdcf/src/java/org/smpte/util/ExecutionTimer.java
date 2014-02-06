package org.smpte.util;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class ExecutionTimer
{
    private static final long[] times = new long[20];

    private static final String ERROR_MESSAGE_1 = "ExecutionTimer only supports " + times.length + " timings at a time.";
    
    private static final String ERROR_MESSAGE_2 = "At the end of the stack.";
    
    
    public static class Time
    {
        private BigInteger took = BigInteger.ZERO;
        
        
        private Time(BigInteger took)
        {
            this.took = took;
        }

        
        private Time(long took)
        {
            this.took = BigInteger.valueOf(took);
        }
        
        
        public double time(TimeUnit unit)
        {
            switch (unit)
            {
                case DAYS :
                    return took.doubleValue() / (double) 86400000000000l;
                case HOURS :
                    return took.doubleValue() / (double) 3600000000000l;
                case MICROSECONDS :
                    return took.doubleValue() / (double) 1000;
                case MILLISECONDS :
                    return took.doubleValue() / (double) 1000000;
                case MINUTES :
                    return took.doubleValue() / (double) 60000000000l;
                case NANOSECONDS :
                    return took.doubleValue();
                case SECONDS :
                    return took.doubleValue() / (double) 1000000000;
                default :
                    return 0;
            }
        }
        
        
        @Override
        public int hashCode()
        {
            return took != null ? took.hashCode() : 0;
        }
        
        
        @Override
        public String toString()
        {
            return "" + took;
        }
    }
    
    
    private static int pos = 0;
    
    
    public final static long start()
    {
        if (pos == times.length)
        {
            throw new ArrayIndexOutOfBoundsException(ERROR_MESSAGE_1);
        }
        
        return times[pos++] = System.nanoTime();
    }
    
    
    public final static int size()
    {
        return pos;
    }
    
    
    public final static double took(TimeUnit unit)
    {
        return took().time(unit);
    }
    
    
    public final static Time took()
    {
        if (pos == 0)
        {
            throw new ArrayIndexOutOfBoundsException(ERROR_MESSAGE_2);
        }
        
        return new Time(System.nanoTime() - times[--pos]);
    }
    
    
    public static final Time sum(Time... tooks)
    {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < tooks.length; i++)
        {
            if (tooks[i] != null)
            {
                sum = sum.add(tooks[i].took);
            }
        }
        return new Time(sum);
    }
    
    
    public static final double sum(double... doubles)
    {
        double sum = 0;
        for (int i = 0; i < doubles.length; i++)
        {
            sum += doubles[i];
        }
        return sum;
    }
    
    
    public static final Time average(Time... tooks)
    {
        return new Time(sum(tooks).took.divide(BigInteger.valueOf(tooks.length)));
    }
    
    
    public static final double average(double... doubles)
    {
        return sum(doubles) / (double) doubles.length;
    }
}
