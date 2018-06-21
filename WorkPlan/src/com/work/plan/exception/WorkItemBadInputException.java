package com.work.plan.exception;

public class WorkItemBadInputException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = -4983495149596247722L;
    
    public WorkItemBadInputException(String aDevMessage, Exception aException)
    {
        super(aDevMessage, aException);
    }
    
    public WorkItemBadInputException(String aDevMessage)
    {
        super(aDevMessage);
    }

}
