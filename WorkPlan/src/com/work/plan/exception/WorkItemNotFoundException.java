package com.work.plan.exception;

public class WorkItemNotFoundException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    public WorkItemNotFoundException(String aDevMessage, Exception aException)
    {
        super(aDevMessage, aException);
    }
    
    public WorkItemNotFoundException(String aDevMessage)
    {
        super(aDevMessage);
    }
}
