
package org.smpte_ra.schemas.st2071._2014.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DATA_TYPE.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DATA_TYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BOOLEAN"/>
 *     &lt;enumeration value="STRING"/>
 *     &lt;enumeration value="INTEGER"/>
 *     &lt;enumeration value="FLOAT"/>
 *     &lt;enumeration value="DATETIME"/>
 *     &lt;enumeration value="URI"/>
 *     &lt;enumeration value="MAP"/>
 *     &lt;enumeration value="BLOB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DATA_TYPE")
@XmlEnum
public enum DATATYPE {

    BOOLEAN,
    STRING,
    INTEGER,
    FLOAT,
    DATETIME,
    URI,
    MAP,
    BLOB;

    public String value() {
        return name();
    }

    public static DATATYPE fromValue(String v) {
        return valueOf(v);
    }

}
