
package org.smpte_ra.schemas.st2071._2014.service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SERVICE_STATE.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SERVICE_STATE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="STARTING"/>
 *     &lt;enumeration value="STARTED"/>
 *     &lt;enumeration value="STOPPING"/>
 *     &lt;enumeration value="STOPPED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SERVICE_STATE")
@XmlEnum
public enum SERVICESTATE {

    STARTING,
    STARTED,
    STOPPING,
    STOPPED;

    public String value() {
        return name();
    }

    public static SERVICESTATE fromValue(String v) {
        return valueOf(v);
    }

}
