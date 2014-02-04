
package org.smpte_ra.schemas.st2071._2014.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OFFSET_TYPE.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OFFSET_TYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SECOND"/>
 *     &lt;enumeration value="MICROSECOND"/>
 *     &lt;enumeration value="BYTE"/>
 *     &lt;enumeration value="FRAME"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OFFSET_TYPE")
@XmlEnum
public enum OFFSETTYPE {

    SECOND,
    MICROSECOND,
    BYTE,
    FRAME;

    public String value() {
        return name();
    }

    public static OFFSETTYPE fromValue(String v) {
        return valueOf(v);
    }

}
