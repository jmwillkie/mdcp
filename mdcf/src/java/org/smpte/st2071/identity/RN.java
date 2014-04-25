package org.smpte.st2071.identity;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.smpte.util.ExecutionTimer;
import org.smpte.util.ExecutionTimer.Time;
import org.smpte.util.FastCharSequence;

/**
 * TODO: implement
 *
 * @author Steve Posick
 */
public abstract class RN extends URN
{
    private static final long serialVersionUID = 201402051137L;

    protected static final String COLON = ":";

    protected static final String TXT_SMPTE = "smpte";

    protected static final String URN_NAMESPACE = URN_SCHEME + COLON + TXT_SMPTE;

    protected static final String RN_FORMAT_PREFIX = URN_NAMESPACE + ":(ucn | udn | umn | usn)";
    
    public static final String FORMAT = RN_FORMAT_PREFIX + ":[<namespace>]:[(*(<name>=<value>)|(<interface name>_v<version>))]";
    
    protected static final int INDEX_URN = 0;
    
    protected static final int INDEX_SMPTE = 1;
    
    protected static final int INDEX_TYPE = 2;
    
    protected static final int INDEX_NAMESPACE = 3;
    
    protected static final int INDEX_INTERFACE = 4;
    
    protected static final int INDEX_ATTRIBUTES = 4;
    
    public static enum Type
    {
        UCN, UDN, UMN, USN;
        

        @Override
        public String toString()
        {
            return super.toString();
        }
        
        
        public static final Type fromText(CharSequence sequence)
        throws ParseException
        {
            if (sequence.length() == 3)
            {
                switch (sequence.charAt(0))
                {
                    case 'U' :
                    case 'u' :
                        switch (sequence.charAt(1))
                        {
                            case 'C' :
                            case 'c' :
                                switch (sequence.charAt(2))
                                {
                                    case 'N' :
                                    case 'n' :
                                        return UCN;
                                    default :
                                        throw new ParseException("\"" + sequence + "\" is not a valid RN type.", 2);
                                }
                            case 'D' :
                            case 'd' :
                                switch (sequence.charAt(2))
                                {
                                    case 'N' :
                                    case 'n' :
                                        return UDN;
                                    default :
                                        throw new ParseException("\"" + sequence + "\" is not a valid RN type.", 2);
                                }
                            case 'M' :
                            case 'm' :
                                switch (sequence.charAt(2))
                                {
                                    case 'N' :
                                    case 'n' :
                                        return UMN;
                                    default :
                                        throw new ParseException("\"" + sequence + "\" is not a valid RN type.", 2);
                                }
                            case 'S' :
                            case 's' :
                                switch (sequence.charAt(2))
                                {
                                    case 'N' :
                                    case 'n' :
                                        return USN;
                                    default :
                                        throw new ParseException("\"" + sequence + "\" is not a valid RN type.", 2);
                                }
                            default :
                                throw new ParseException("\"" + sequence + "\" is not a valid RN type.", 1);
                        }
                    default :
                        throw new ParseException("\"" + sequence + "\" is not a valid RN type.", 0);
                }
            }
            
            throw new ParseException("\"" + sequence + "\" is not a valid RN type.", 0);
        }
    }
    
    
    protected String string;
    
    protected Type type;

    protected CharSequence namespace;

    protected boolean isNamespace;

    protected boolean isRootNamespace;
    
    
    protected RN()
    {
        super();
    }
    
    
    protected RN(Type type)
    throws ParseException
    {
        this();
        if (type != null)
        {
            this.type = type;
            this.isRootNamespace = this.isNamespace = true;
        } else
        {
            throw new ParseException("RN must start with \"" + RN_FORMAT_PREFIX + "\".", 0);
        }
    }
    
    
    protected RN(Type type, CharSequence... parts)
    throws ParseException
    {
        this(type, convertParts(parts));
    }


    protected RN(Type type, FastCharSequence... parts)
    throws ParseException
    {
        this();
        if (type != null)
        {
            this.type = type;
            if (parts.length >= INDEX_NAMESPACE)
            {
                this.namespace = parts[INDEX_NAMESPACE];
                this.isRootNamespace = this.isNamespace = namespace == null || namespace.length() == 0;
            } else
            {
                this.isRootNamespace = this.isNamespace = true;
            }
        } else
        {
            throw new ParseException("RN must start with \"" + RN_FORMAT_PREFIX + "\".", parts[INDEX_TYPE].getStartPosInSource());
        }
    }
    
    
    public Type getType()
    {
        return type;
    }
    
    
    public String getNamespace()
    {
        return namespace.toString();
    }
    
    
    public boolean isNamespaceName()
    {
        return isNamespace;
    }
    
    
    public boolean isRootNamespaceName()
    {
        return isRootNamespace;
    }
    
    
    @Override
    public String toString()
    {
        if (this.string == null)
        {
            StringBuilder b = new StringBuilder(100);
            
            b.append(URN_NAMESPACE).append(COLON).append(type.toString().toLowerCase()).append(COLON).append(namespace).append(COLON);
            
            if (isNamespaceName())
            {
                b.append(" [").append(type.toString()).append(isRootNamespaceName() ? " Root" : "").append(" ").append("Namespace Name").append("]");
            }
            
            this.string = b.toString();
        }
        
        return this.string;
    }
    
    
    protected static FastCharSequence[] convertParts(CharSequence[] parts)
    {
        CharSequence part;
        FastCharSequence[] fastParts = new FastCharSequence[parts.length];
        for (int index = 0; index < parts.length; index++)
        {
            part = parts[index];
            if (part instanceof FastCharSequence)
            {
                fastParts[index] = (FastCharSequence) part;
            } else
            {
                fastParts[index] = new FastCharSequence(part);
            }
        }
        return fastParts;
    }
    
    
    protected static RN newRN(CharSequence source) 
    throws ParseException
    {
        final FastCharSequence rn = source instanceof FastCharSequence ? (FastCharSequence) source : new FastCharSequence(source);
        final FastCharSequence[] parts = rn.split(COLON);
        
        try
        {
            Type type = parseType(parts);
            if (type != null)
            {
                switch (type)
                {
                    case UCN :
                        return new UCN(parts);
                    case UDN :
                        return new UDN(parts);
                    case UMN :
                        return new UMN(parts);
                    case USN :
                        return new USN(parts);
                    default :
                        throw new ParseException("RN must start with \"" + RN_FORMAT_PREFIX + "\".", parts[INDEX_TYPE].getStartPosInSource());
                }
            } else
            {
                throw new ParseException("RN must start with \"" + RN_FORMAT_PREFIX + "\".", parts[INDEX_TYPE].getStartPosInSource());
            }
        } catch (ParseException e)
        {
            throw new ParseException("\"" + rn + "\" is not a valid RN. " + e.getMessage(), e.getErrorOffset());
        }
    }
    
    
    protected static Type parseType(final FastCharSequence[] parts)
    throws ParseException
    {
        if (parts.length >= INDEX_TYPE)
        {
            if (parts[0].length() == URN_SCHEME.length() && 
                (parts[0].charAt(0) == URN_SCHEME.charAt(0) || Character.toLowerCase(parts[0].charAt(0)) == URN_SCHEME.charAt(0)) && 
                (parts[0].charAt(1) == URN_SCHEME.charAt(1) || Character.toLowerCase(parts[0].charAt(1)) == URN_SCHEME.charAt(1)) && 
                (parts[0].charAt(2) == URN_SCHEME.charAt(2) || Character.toLowerCase(parts[0].charAt(2)) == URN_SCHEME.charAt(2)))
            {
                if (parts[1].length() == TXT_SMPTE.length() && 
                    (parts[1].charAt(0) == TXT_SMPTE.charAt(0) || Character.toLowerCase(parts[1].charAt(0)) == TXT_SMPTE.charAt(0)) && 
                    (parts[1].charAt(1) == TXT_SMPTE.charAt(1) || Character.toLowerCase(parts[1].charAt(1)) == TXT_SMPTE.charAt(1)) && 
                    (parts[1].charAt(2) == TXT_SMPTE.charAt(2) || Character.toLowerCase(parts[1].charAt(2)) == TXT_SMPTE.charAt(2)) && 
                    (parts[1].charAt(3) == TXT_SMPTE.charAt(3) || Character.toLowerCase(parts[1].charAt(3)) == TXT_SMPTE.charAt(3)) && 
                    (parts[1].charAt(4) == TXT_SMPTE.charAt(4) || Character.toLowerCase(parts[1].charAt(4)) == TXT_SMPTE.charAt(4)))
                {
                    FastCharSequence sequence = parts[INDEX_TYPE];
                    Type type = Type.fromText(sequence);
                    if (type != null)
                    {
                        return type;
                    } else
                    {
                        throw new ParseException("\"" + sequence + "\" is not a valid RN type.  RN must start with \"" + RN_FORMAT_PREFIX + "\".", parts[INDEX_TYPE].getStartPosInSource());
                    }
                } else
                {
                    throw new ParseException("RN must start with \"" + URN_NAMESPACE + "\".", parts[INDEX_SMPTE].getStartPosInSource());
                }
            } else
            {
                throw new ParseException("RN must start with \"" + URN_SCHEME + "\".", parts[INDEX_URN].getStartPosInSource());
            }
        } else
        {
            throw new ParseException("RN must be in the format \"" + URN_NAMESPACE + "\".", 0);
        }
    }


    protected static FastCharSequence[] convertToPartsOfType(Type type, CharSequence source)
    throws ParseException
    {
        final FastCharSequence rn = source instanceof FastCharSequence ? (FastCharSequence) source : new FastCharSequence(source);
        final FastCharSequence[] parts = rn.split(COLON);

        Type actualType = parseType(parts);
        if (actualType != null && actualType == type)
        {
            return parts;
        } else
        {
            throw new ParseException("RN's of type " + type.name() + " must start with \"" + URN_NAMESPACE + COLON + type.name().toLowerCase() + COLON + "\".", parts[INDEX_TYPE].getStartPosInSource());
        }
    }
    
    
    public static void main(String... args)
    {
        // Test performance.
        String[] testStrings = new String[] 
        {
            "urn:smpte:udn::",
            "urn:smpte:umn::",
            "urn:smpte:usn::",
            "urn:smpte:ucn::",
            "urn:smpte:udn:org.smpte:",
            "urn:smpte:umn:org.smpte:",
            "urn:smpte:usn:org.smpte:",
            "urn:smpte:ucn:org.smpte:",
            "Urn:smpte:udn:org.smpte.1.attribute:id=1",
            "uRn:smpte:udn:org.smpte.2.attributes:id=1,2=test2",
            "urN:smpte:udn:org.smpte.3.attributes:id=1,2=test2,3=test3",
            "urn:Smpte:udn:org.smpte.4.attributes:id=1,2=test2,3=test3,4=test4",
            "urn:sMpte:udn:org.smpte.2.attributes:id=1;2=test2",
            "urn:smPte:udn:org.smpte.3.attributes:id=1;2=test2;3=test3",
            "urn:smpTe:udn:org.smpte.4.attributes:id=1;2=test2;3=test3;4=test4",
            "urn:smptE:umn:org.smpte.1.attribute:type=media_asset",
            "urn:smpte:umn:org.smpte.2.attribute:type=media_asset,id=1",
            "urn:smpte:umn:org.smpte.3.attribute:type=media_asset,id=1,3=test3",
            "urn:smpte:umn:org.smpte.3.attribute:type=media_asset,id=1,3=test3,4=test4",
            "urn:smpte:umn:org.smpte.2.attribute:type=media_asset;id=1",
            "urn:smpte:umn:org.smpte.3.attribute:type=media_asset;id=1;3=test3",
            "urn:smpte:umn:org.smpte.3.attribute:type=media_asset;id=1;3=test3;4=test4",
            "urn:smpte:usn:org.smpte.1.attribute:id=1",
            "urn:smpte:usn:org.smpte.2.attributes:id=1,2=test2",
            "urn:smpte:usn:org.smpte.3.attributes:id=1,2=test2,3=test3",
            "urn:smpte:usn:org.smpte.4.attributes:id=1,2=test2,3=test3,4=test4",
            "urn:smpte:usn:org.smpte.2.attributes:id=1;2=test2",
            "urn:smpte:usn:org.smpte.3.attributes:id=1;2=test2;3=test3",
            "urn:smpte:usn:org.smpte.4.attributes:id=1;2=test2;3=test3;4=test4",
            "urn:smpte:ucn:org.smpte.st2071:device_v1",
            "urn:smpte:ucn:org.smpte.st2071:device_directory_v1",
            "urn:smpte:ucn:org.smpte.st2071:media_directory_v1",
            "urn:smpte:ucn:org.smpte.st2071.1.zeros:test_v1.0",
            "urn:smpte:ucn:org.smpte.st2071.2.zeros:test_v1.0.0",
            "urn:smpte:ucn:org.smpte.st2071.3.zeros:test_v1.0.0.0"
        };
        
        final int TIMES = 100;
        final long TESTS = 1000;
        final TimeUnit TOTAL_TIME_UNIT = TimeUnit.SECONDS;
        final TimeUnit GROUP_TIME_UNIT = TimeUnit.MILLISECONDS;
        final TimeUnit SINGLE_TIME_UNIT = TimeUnit.MICROSECONDS;
        
        Time[] fastTests = new Time[TIMES];
        
        long executions = 0;
        
        try
        {
            for (int times = 0; times < TIMES; times++)
            {
                ExecutionTimer.start();
                for (int index = 0; index < testStrings.length; index++)
                {
                    final FastCharSequence sequence = new FastCharSequence(testStrings[index]);
                    for (int count = 0; count < TESTS; count++)
                    {
                        RN.newRN(sequence);
                        executions++;
                    }
                }
                fastTests[times] = ExecutionTimer.took();
            }
        } catch (ParseException e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        }
        
        Time average = ExecutionTimer.average(fastTests);
        Time sum = ExecutionTimer.sum(fastTests);
        System.out.println("Fast Test: " + executions + " test executions over " + sum.time(TOTAL_TIME_UNIT) + " " + TOTAL_TIME_UNIT.name() + "; Averaging " + average.time(GROUP_TIME_UNIT) + " " + GROUP_TIME_UNIT.name() + " per test group and " + (sum.time(SINGLE_TIME_UNIT) / (double) executions) + " " + SINGLE_TIME_UNIT.name() + " average execution time per test.");
    }
}