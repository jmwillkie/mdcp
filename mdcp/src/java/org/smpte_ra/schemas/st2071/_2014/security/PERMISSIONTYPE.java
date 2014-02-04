
package org.smpte_ra.schemas.st2071._2014.security;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PERMISSION_TYPE.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PERMISSION_TYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="READ"/>
 *     &lt;enumeration value="WRITE"/>
 *     &lt;enumeration value="EXECUTE"/>
 *     &lt;enumeration value="DELETE"/>
 *     &lt;enumeration value="ADMINISTER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PERMISSION_TYPE")
@XmlEnum
public enum PERMISSIONTYPE {

    READ,
    WRITE,
    EXECUTE,
    DELETE,
    ADMINISTER;

    public String value() {
        return name();
    }

    public static PERMISSIONTYPE fromValue(String v) {
        return valueOf(v);
    }

}
