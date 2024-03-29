
package org.smpte_ra.schemas.st2071._2014.query;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NOT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NOT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.smpte-ra.org/schemas/st2071/2014/query}Expression">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/query}Expression"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NOT", propOrder = {
    "expression"
})
public class NOT
    extends Expression
{

    @XmlElementRef(name = "Expression", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", type = JAXBElement.class)
    protected JAXBElement<? extends Expression> expression;

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

}
