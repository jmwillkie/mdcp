
package org.smpte_ra.schemas.st2071._2014.query;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryExpression complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryExpression">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/query}Expression" minOccurs="0"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/query}PAGE" minOccurs="0"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/query}SORT_BY" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryExpression", propOrder = {
    "expression",
    "page",
    "sortby"
})
public abstract class QueryExpression {

    @XmlElementRef(name = "Expression", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends Expression> expression;
    @XmlElement(name = "PAGE")
    protected PAGE page;
    @XmlElement(name = "SORT_BY")
    protected List<SORTBY> sortby;

    /**
     * Gets the value of the expression property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NOT }{@code >}
     *     {@link JAXBElement }{@code <}{@link IMPLEMENTS }{@code >}
     *     {@link JAXBElement }{@code <}{@link EQUALS }{@code >}
     *     {@link JAXBElement }{@code <}{@link MATCHES }{@code >}
     *     {@link JAXBElement }{@code <}{@link OR }{@code >}
     *     {@link JAXBElement }{@code <}{@link Expression }{@code >}
     *     {@link JAXBElement }{@code <}{@link AND }{@code >}
     *     {@link JAXBElement }{@code <}{@link CONTAINS }{@code >}
     *     {@link JAXBElement }{@code <}{@link LESSTHAN }{@code >}
     *     {@link JAXBElement }{@code <}{@link GREATERTHAN }{@code >}
     *     
     */
    public JAXBElement<? extends Expression> getExpression() {
        return expression;
    }

    /**
     * Sets the value of the expression property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NOT }{@code >}
     *     {@link JAXBElement }{@code <}{@link IMPLEMENTS }{@code >}
     *     {@link JAXBElement }{@code <}{@link EQUALS }{@code >}
     *     {@link JAXBElement }{@code <}{@link MATCHES }{@code >}
     *     {@link JAXBElement }{@code <}{@link OR }{@code >}
     *     {@link JAXBElement }{@code <}{@link Expression }{@code >}
     *     {@link JAXBElement }{@code <}{@link AND }{@code >}
     *     {@link JAXBElement }{@code <}{@link CONTAINS }{@code >}
     *     {@link JAXBElement }{@code <}{@link LESSTHAN }{@code >}
     *     {@link JAXBElement }{@code <}{@link GREATERTHAN }{@code >}
     *     
     */
    public void setExpression(JAXBElement<? extends Expression> value) {
        this.expression = value;
    }

    /**
     * Gets the value of the page property.
     * 
     * @return
     *     possible object is
     *     {@link PAGE }
     *     
     */
    public PAGE getPAGE() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     * @param value
     *     allowed object is
     *     {@link PAGE }
     *     
     */
    public void setPAGE(PAGE value) {
        this.page = value;
    }

    /**
     * Gets the value of the sortby property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sortby property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSORTBY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SORTBY }
     * 
     * 
     */
    public List<SORTBY> getSORTBY() {
        if (sortby == null) {
            sortby = new ArrayList<SORTBY>();
        }
        return this.sortby;
    }

}
