
package org.smpte_ra.schemas.st2071._2014.query;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:42:23.294-04:00
 * Generated source version: 2.7.10
 */

@WebFault(name = "InvalidQuery", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/query")
public class InvalidQueryFault extends java.lang.Exception {
    
    private org.smpte_ra.schemas.st2071._2014.query.InvalidQuery invalidQuery;

    public InvalidQueryFault() {
        super();
    }
    
    public InvalidQueryFault(String message) {
        super(message);
    }
    
    public InvalidQueryFault(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidQueryFault(String message, org.smpte_ra.schemas.st2071._2014.query.InvalidQuery invalidQuery) {
        super(message);
        this.invalidQuery = invalidQuery;
    }

    public InvalidQueryFault(String message, org.smpte_ra.schemas.st2071._2014.query.InvalidQuery invalidQuery, Throwable cause) {
        super(message, cause);
        this.invalidQuery = invalidQuery;
    }

    public org.smpte_ra.schemas.st2071._2014.query.InvalidQuery getFaultInfo() {
        return this.invalidQuery;
    }
}
