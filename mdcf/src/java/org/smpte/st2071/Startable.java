package org.smpte.st2071;

public interface Startable
{
    /**
     * Starts the Discovery Service and its time processes.
     * 
     * @throws Exception if the Discover Service cannot be started for any reason.
     */
    public void start()
    throws Exception;
}
