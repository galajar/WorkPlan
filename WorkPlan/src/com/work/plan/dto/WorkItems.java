package com.work.plan.dto;
import java.util.ArrayList;
import java.util.List;

import com.work.plan.exception.WorkItemBadInputException;
import com.work.plan.exception.WorkItemNotFoundException;

public class WorkItems
{



    private List<WorkItem> items = new ArrayList<WorkItem>();
    
    public WorkItem getItem(int aId) throws WorkItemNotFoundException {
        WorkItem lItem = null;
        
        if(null != items && !items.isEmpty()) {
            for (WorkItem item : items) {
                if(item.getId() == aId) {
                    lItem = item;
                    break;
                }
            }
        }
        
        if (null == lItem) {
            throw new WorkItemNotFoundException("Missing Work Item Dependencies");
        }
        
        return lItem;
    }
    
    public List<WorkItem> getItems()
    {
        return items;
    }


    
    public void addItem(WorkItem item) throws WorkItemBadInputException
    {
        if (null == item) {
            throw new WorkItemBadInputException("Invalid Item");
        }
        this.items.add(item);
    }
}
