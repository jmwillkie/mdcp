
package org.smpte_ra.schemas.st2071._2014.security;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EXCEPTION_TYPE.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EXCEPTION_TYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AUTHENTICATION"/>
 *     &lt;enumeration value="AUTHORIZATION"/>
 *     &lt;enumeration value="SECURITY_LAYER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EXCEPTION_TYPE")
@XmlEnum
public enum EXCEPTIONTYPE {

    AUTHENTICATION,
    AUTHORIZATION,
    SECURITY_LAYER;

    public String value() {
        return name();
    }

    public static EXCEPTIONTYPE fromValue(String v) {
        return valueOf(v);
    }

}
