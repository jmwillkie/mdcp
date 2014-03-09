
package org.smpte_ra.schemas.st2071._2014.session;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ControlEventType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ControlEventType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RequestAcquire"/>
 *     &lt;enumeration value="RequestLock"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Denied"/>
 *     &lt;enumeration value="SessionTaken"/>
 *     &lt;enumeration value="LockTaken"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ControlEventType")
@XmlEnum
public enum ControlEventType {

    @XmlEnumValue("RequestAcquire")
    REQUEST_ACQUIRE("RequestAcquire"),
    @XmlEnumValue("RequestLock")
    REQUEST_LOCK("RequestLock"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Denied")
    DENIED("Denied"),
    @XmlEnumValue("SessionTaken")
    SESSION_TAKEN("SessionTaken"),
    @XmlEnumValue("LockTaken")
    LOCK_TAKEN("LockTaken");
    private final String value;

    ControlEventType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ControlEventType fromValue(String v) {
        for (ControlEventType c: ControlEventType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
