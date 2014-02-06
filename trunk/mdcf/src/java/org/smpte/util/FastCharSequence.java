package org.smpte.util;

import java.util.ArrayList;

public final class FastCharSequence implements CharSequence
{
    private static final FastCharSequence[] EMPTY_ARRAY = new FastCharSequence[0];

    private int end;
    
    private int start;
    
    private CharSequence source;

    private String string;

    private String sourceString;
    
    
    public FastCharSequence(final CharSequence source)
    {
        this.end = source.length();
        this.start = 0;
        this.source = source;
    }
    
    
    public FastCharSequence(final CharSequence source, final int start, final int end)
    {
        this.end = end;
        this.start = start;
        this.source = source;
    }


    public final int length()
    {
        return end - start;
    }
    
    
    public final char charAt(int index)
    {
        return source.charAt(this.start + index);
    }
    
    
    public final FastCharSequence subSequence(int start, int end)
    {
        return new FastCharSequence(source, this.start + start, this.start + end);
    }
    
    
    public final int getStartPosInSource()
    {
        return this.start; 
    }
    
    
    public final int getEndPosInSource()
    {
        return this.end; 
    }
    
    
    public int indexOf(final char ch)
    {
        return indexOf(ch, 0);
    }
    
    
    public int indexOf(final char ch, final int fromIndex)
    {
        if (fromIndex >= length())
        {
            return -1;
        }
        
        final char character = ch; 
        final int startIndex = fromIndex < 0 ? 0 : fromIndex;
        
        final int start = this.start; /* avoid getfield opcode */
        final int end = this.end; /* avoid getfield opcode */
        final CharSequence data = this.source; /* avoid getfield opcode */
        
        for (int index = startIndex + start; index < end; index++)
        {
            if (data.charAt(index) == character)
            {
                return index - start;
            }
        }
        
        return -1;
    }
    
    
    public int lastIndexOf(final char ch)
    {
        return lastIndexOf(ch, this.end);
    }
    
    
    public int lastIndexOf(final char ch, final int fromIndex)
    {
        if (fromIndex < 0)
        {
            return -1;
        }
        
        final char character = ch; 
        
        final int length = length();
        final int start = this.start; /* avoid getfield opcode */
        final int end = this.end; /* avoid getfield opcode */
        final CharSequence data = this.source; /* avoid getfield opcode */
        final int startIndex = fromIndex >= length ? end - 1 : fromIndex;
        
        if (character < Character.MIN_SUPPLEMENTARY_CODE_POINT) 
        {
            for (int index = startIndex; index >= start; index--)
            {
                if (data.charAt(index) == character)
                {
                    return index - start;
                }
            }
        }
        
        if (character <= Character.MAX_CODE_POINT)
        {
            // handle supplementary characters here
            char[] surrogates = Character.toChars(character);
            for (int index = start + startIndex; index >= start; index--)
            {
                if (data.charAt(index) == surrogates[0])
                {
                    int testIndex = index - 1;
                    if (testIndex == start)
                    {
                        break;
                    }
                    if (data.charAt(testIndex) == surrogates[1])
                    {
                        return index - start;
                    }
                }
            }
        }
        
        return -1;
    }
    
    
    /**
     * Splits the string using the specified delimiter.
     * 
     * @param delimiter The delimiter.
     * 
     * @return An array containing the character sequences between the delimiters.
     */
    public FastCharSequence[] split(String delimiters)
    {
        return split(delimiters, false);
    }
    
    
    /**
     * Splits the string using the specified delimiter.
     * 
     * @param delimiter The delimiter.
     * @param returnDelimiters Add delimiters to the results
     * 
     * @return An array containing the character sequences between the delimiters.
     */
    public FastCharSequence[] split(String delimiters, boolean returnDelimiters)
    {
        final int start = this.start; /* avoid getfield opcode */
        final int end = this.end; /* avoid getfield opcode */
        
        if (end - start <= 0)
        {
            return EMPTY_ARRAY;
        }
        
        final ArrayList<FastCharSequence> list = new ArrayList<>();
        final CharSequence data = this.source; /* avoid getfield opcode */
        final char[] delimiter = delimiters.toCharArray();
        int startPos = start;
        
        for (int index = start; index < end; index++)
        {
            for (int i = 0; i < delimiter.length; i++)
            {
                if (data.charAt(index) == delimiter[i])
                {
                    list.add(subSequence(startPos - start, index - start));
                    startPos = index + 1;
                    if (returnDelimiters)
                    {
                        list.add(subSequence(index - start, (index - start) + 1));
                    }
                }
            }
        }
        
        if (startPos <= end)
        {
            list.add(new FastCharSequence(data, startPos, end));
        }
        
        return (FastCharSequence[]) list.toArray(new FastCharSequence[list.size()]);
    }
    
    
    public String toString()
    {
        if (string == null)
        {
            char[] chars = new char[length()];
            for (int index = 0; index < chars.length; index++)
            {
                chars[index] = charAt(index);
            }
            
            string = new String(chars);
        }
        
        return string;
    }
    
    
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        } else if (this == o)
        {
            return true;
        } else
        {
            if (sourceString == null)
            {
                sourceString = toString();
            }
            return sourceString.equals((String) o);
        }
    }
    
    /*
    public static void main(String... args)
    {
        // Test performance.
        String[] testStrings = new String[] 
        {
            "urn:smpte:udn:org.smpte.pcr.1:id=1,test=test",
            "urn:smpte:umn:org.smpte:type=media_asset,id=2,test=test",
            "urn:smpte:usn:org.smpte.mcr.1:id=3,test=test",
            "urn:smpte:ucn:org.smpte.st2071:Device_v1",
        };
        
        final int TIMES = 100;
        final long TESTS = 10000;
        final TimeUnit TOTAL_TIME_UNIT = TimeUnit.MILLISECONDS;
        final TimeUnit GROUP_TIME_UNIT = TimeUnit.MICROSECONDS;
        final TimeUnit SINGLE_TIME_UNIT = TimeUnit.NANOSECONDS;
        
        Time[] stringTests = new Time[TIMES];
        Time[] fastTests = new Time[TIMES];
        
        long stringExecutions = 0;
        long fastExecutions = 0;
        
        for (int times = 0; times < TIMES; times++)
        {
            ExecutionTimer.start();
            for (int index = 0; index < testStrings.length; index++)
            {
                final String string = new String(testStrings[index]);
                for (int count = 0; count < TESTS; count++)
                {
//                    string.equals(testStrings[index]);
//                    string.toString();
//                    string.split(":=");
                    string.subSequence(10, 20);
//                    string.indexOf("_");
                      stringExecutions++;
                }
            }
            stringTests[times] = ExecutionTimer.took();
            
            ExecutionTimer.start();
            for (int index = 0; index < testStrings.length; index++)
            {
                final FastCharSequence sequence = new FastCharSequence(testStrings[index]);
                for (int count = 0; count < TESTS; count++)
                {
//                    sequence.equals(testStrings[index]);
//                    sequence.toString();
//                    sequence.split(":=");
                    sequence.subSequence(10, 20);
//                    sequence.indexOf('_');
                      fastExecutions++;
                }
            }
            fastTests[times] = ExecutionTimer.took();
        }
        
        Time average = ExecutionTimer.average(stringTests);
        Time sum = ExecutionTimer.sum(stringTests);
        System.out.println("String Test: " + stringExecutions + " test executions over " + sum.time(TOTAL_TIME_UNIT) + " " + TOTAL_TIME_UNIT.name() + "; Averaging " + average.time(GROUP_TIME_UNIT) + " " + GROUP_TIME_UNIT.name() + " per test group and " + (sum.time(SINGLE_TIME_UNIT) / (double) stringExecutions) + " " + SINGLE_TIME_UNIT.name() + " average execution time per test.");
        
        average = ExecutionTimer.average(fastTests);
        sum = ExecutionTimer.sum(fastTests);
        System.out.println("Fast Test: " + fastExecutions + " test executions over " + sum.time(TOTAL_TIME_UNIT) + " " + TOTAL_TIME_UNIT.name() + "; Averaging " + average.time(GROUP_TIME_UNIT) + " " + GROUP_TIME_UNIT.name() + " per test group and " + (sum.time(SINGLE_TIME_UNIT) / (double) fastExecutions) + " " + SINGLE_TIME_UNIT.name() + " average execution time per test.");
    }
    */
}
