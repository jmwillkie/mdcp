
package org.smpte_ra.schemas.st2071._2014.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.query.QueryExpression;


/**
 * <p>Java class for QueryRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/query}QueryExpression" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryRequest", propOrder = {
    "queryExpression"
})
public class QueryRequest {

    @XmlElement(name = "QueryExpression", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query")
    protected QueryExpression queryExpression;

    /**
     * Gets the value of the queryExpression property.
     * 
     * @return
     *     possible object is
     *     {@link QueryExpression }
     *     
     */
    public QueryExpression getQueryExpression() {
        return queryExpression;
    }

    /**
     * Sets the value of the queryExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryExpression }
     *     
     */
    public void setQueryExpression(QueryExpression value) {
        this.queryExpression = value;
    }

}
