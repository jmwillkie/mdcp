
package org.smpte_ra.schemas.st2071._2014.security;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EXCEPTION_STATUS.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EXCEPTION_STATUS">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="REQUIRED"/>
 *     &lt;enumeration value="FAILED"/>
 *     &lt;enumeration value="ABORTED"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="EXPIRED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EXCEPTION_STATUS")
@XmlEnum
public enum EXCEPTIONSTATUS {

    REQUIRED,
    FAILED,
    ABORTED,
    ERROR,
    EXPIRED;

    public String value() {
        return name();
    }

    public static EXCEPTIONSTATUS fromValue(String v) {
        return valueOf(v);
    }

}
