
package org.smpte_ra.schemas.st2071._2014.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for STATUS.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="STATUS">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="WARNING"/>
 *     &lt;enumeration value="ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "STATUS")
@XmlEnum
public enum STATUS {

    OK,
    WARNING,
    ERROR;

    public String value() {
        return name();
    }

    public static STATUS fromValue(String v) {
        return valueOf(v);
    }

}
