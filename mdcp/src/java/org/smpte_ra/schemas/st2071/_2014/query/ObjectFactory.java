
package org.smpte_ra.schemas.st2071._2014.query;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.smpte_ra.schemas.st2071._2014.types.Capabilities;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.smpte_ra.schemas.st2071._2014.query package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IMPLEMENTS_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "IMPLEMENTS");
    private final static QName _GREATERTHAN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "GREATER_THAN");
    private final static QName _MATCHES_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "MATCHES");
    private final static QName _QueryExpression_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "QueryExpression");
    private final static QName _NOT_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "NOT");
    private final static QName _CONTAINS_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "CONTAINS");
    private final static QName _RegExp_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "RegExp");
    private final static QName _LESSTHAN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "LESS_THAN");
    private final static QName _Expression_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "Expression");
    private final static QName _Number_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "Number");
    private final static QName _AND_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "AND");
    private final static QName _Interfaces_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "Interfaces");
    private final static QName _SORTBY_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "SORT_BY");
    private final static QName _PAGE_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "PAGE");
    private final static QName _EQUALS_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "EQUALS");
    private final static QName _OR_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "OR");
    private final static QName _Object_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "Object");
    private final static QName _InvalidQuery_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "InvalidQuery");
    private final static QName _Time_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/query", "Time");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.smpte_ra.schemas.st2071._2014.query
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PAGE }
     * 
     */
    public PAGE createPAGE() {
        return new PAGE();
    }

    /**
     * Create an instance of {@link GREATERTHAN }
     * 
     */
    public GREATERTHAN createGREATERTHAN() {
        return new GREATERTHAN();
    }

    /**
     * Create an instance of {@link IMPLEMENTS }
     * 
     */
    public IMPLEMENTS createIMPLEMENTS() {
        return new IMPLEMENTS();
    }

    /**
     * Create an instance of {@link MATCHES }
     * 
     */
    public MATCHES createMATCHES() {
        return new MATCHES();
    }

    /**
     * Create an instance of {@link CONTAINS }
     * 
     */
    public CONTAINS createCONTAINS() {
        return new CONTAINS();
    }

    /**
     * Create an instance of {@link OR }
     * 
     */
    public OR createOR() {
        return new OR();
    }

    /**
     * Create an instance of {@link LESSTHAN }
     * 
     */
    public LESSTHAN createLESSTHAN() {
        return new LESSTHAN();
    }

    /**
     * Create an instance of {@link EQUALS }
     * 
     */
    public EQUALS createEQUALS() {
        return new EQUALS();
    }

    /**
     * Create an instance of {@link NOT }
     * 
     */
    public NOT createNOT() {
        return new NOT();
    }

    /**
     * Create an instance of {@link AND }
     * 
     */
    public AND createAND() {
        return new AND();
    }

    /**
     * Create an instance of {@link InvalidQuery }
     * 
     */
    public InvalidQuery createInvalidQuery() {
        return new InvalidQuery();
    }

    /**
     * Create an instance of {@link SORTBY }
     * 
     */
    public SORTBY createSORTBY() {
        return new SORTBY();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IMPLEMENTS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "IMPLEMENTS", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", substitutionHeadName = "Expression")
    public JAXBElement<IMPLEMENTS> createIMPLEMENTS(IMPLEMENTS value) {
        return new JAXBElement<IMPLEMENTS>(_IMPLEMENTS_QNAME, IMPLEMENTS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GREATERTHAN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "GREATER_THAN", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", substitutionHeadName = "Expression")
    public JAXBElement<GREATERTHAN> createGREATERTHAN(GREATERTHAN value) {
        return new JAXBElement<GREATERTHAN>(_GREATERTHAN_QNAME, GREATERTHAN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MATCHES }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "MATCHES", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", substitutionHeadName = "Expression")
    public JAXBElement<MATCHES> createMATCHES(MATCHES value) {
        return new JAXBElement<MATCHES>(_MATCHES_QNAME, MATCHES.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryExpression }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "QueryExpression")
    public JAXBElement<QueryExpression> createQueryExpression(QueryExpression value) {
        return new JAXBElement<QueryExpression>(_QueryExpression_QNAME, QueryExpression.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NOT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "NOT", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", substitutionHeadName = "Expression")
    public JAXBElement<NOT> createNOT(NOT value) {
        return new JAXBElement<NOT>(_NOT_QNAME, NOT.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CONTAINS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "CONTAINS", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", substitutionHeadName = "Expression")
    public JAXBElement<CONTAINS> createCONTAINS(CONTAINS value) {
        return new JAXBElement<CONTAINS>(_CONTAINS_QNAME, CONTAINS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "RegExp")
    public JAXBElement<String> createRegExp(String value) {
        return new JAXBElement<String>(_RegExp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LESSTHAN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "LESS_THAN", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", substitutionHeadName = "Expression")
    public JAXBElement<LESSTHAN> createLESSTHAN(LESSTHAN value) {
        return new JAXBElement<LESSTHAN>(_LESSTHAN_QNAME, LESSTHAN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Expression }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "Expression")
    public JAXBElement<Expression> createExpression(Expression value) {
        return new JAXBElement<Expression>(_Expression_QNAME, Expression.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "Number")
    public JAXBElement<BigDecimal> createNumber(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Number_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AND }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "AND", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", substitutionHeadName = "Expression")
    public JAXBElement<AND> createAND(AND value) {
        return new JAXBElement<AND>(_AND_QNAME, AND.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Capabilities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "Interfaces")
    public JAXBElement<Capabilities> createInterfaces(Capabilities value) {
        return new JAXBElement<Capabilities>(_Interfaces_QNAME, Capabilities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SORTBY }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "SORT_BY")
    public JAXBElement<SORTBY> createSORTBY(SORTBY value) {
        return new JAXBElement<SORTBY>(_SORTBY_QNAME, SORTBY.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PAGE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "PAGE")
    public JAXBElement<PAGE> createPAGE(PAGE value) {
        return new JAXBElement<PAGE>(_PAGE_QNAME, PAGE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EQUALS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "EQUALS", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", substitutionHeadName = "Expression")
    public JAXBElement<EQUALS> createEQUALS(EQUALS value) {
        return new JAXBElement<EQUALS>(_EQUALS_QNAME, EQUALS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OR }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "OR", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", substitutionHeadName = "Expression")
    public JAXBElement<OR> createOR(OR value) {
        return new JAXBElement<OR>(_OR_QNAME, OR.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "Object")
    public JAXBElement<Object> createObject(Object value) {
        return new JAXBElement<Object>(_Object_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidQuery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "InvalidQuery", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<InvalidQuery> createInvalidQuery(InvalidQuery value) {
        return new JAXBElement<InvalidQuery>(_InvalidQuery_QNAME, InvalidQuery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/query", name = "Time")
    public JAXBElement<DateTime> createTime(DateTime value) {
        return new JAXBElement<DateTime>(_Time_QNAME, DateTime.class, null, value);
    }

}
