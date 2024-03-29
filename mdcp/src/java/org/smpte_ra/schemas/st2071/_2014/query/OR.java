
package org.smpte_ra.schemas.st2071._2014.query;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OR complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OR">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.smpte-ra.org/schemas/st2071/2014/query}Expression">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/query}Expression" maxOccurs="unbounded" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OR", propOrder = {
    "expression"
})
public class OR
    extends Expression
{

    @XmlElementRef(name = "Expression", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", type = JAXBElement.class)
    protected List<JAXBElement<? extends Expression>> expression;

    /**
     * Gets the value of the expression property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the expression property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpression().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link NOT }{@code >}
     * {@link JAXBElement }{@code <}{@link IMPLEMENTS }{@code >}
     * {@link JAXBElement }{@code <}{@link EQUALS }{@code >}
     * {@link JAXBElement }{@code <}{@link MATCHES }{@code >}
     * {@link JAXBElement }{@code <}{@link OR }{@code >}
     * {@link JAXBElement }{@code <}{@link Expression }{@code >}
     * {@link JAXBElement }{@code <}{@link AND }{@code >}
     * {@link JAXBElement }{@code <}{@link CONTAINS }{@code >}
     * {@link JAXBElement }{@code <}{@link LESSTHAN }{@code >}
     * {@link JAXBElement }{@code <}{@link GREATERTHAN }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends Expression>> getExpression() {
        if (expression == null) {
            expression = new ArrayList<JAXBElement<? extends Expression>>();
        }
        return this.expression;
    }

}
