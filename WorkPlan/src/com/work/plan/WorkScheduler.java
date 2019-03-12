package com.work.plan;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.work.plan.dto.WorkItem;
import com.work.plan.dto.WorkItems;
import com.work.plan.exception.WorkItemBadInputException;
import com.work.plan.exception.WorkItemNotFoundException;
import com.work.plan.util.WorkItemComparitor;

public class WorkScheduler
{

    public static void main(String[] args) throws WorkItemBadInputException, WorkItemNotFoundException
    {
        WorkItems lItems1 = createWorkItems();
        for(WorkItem item1 : lItems1.getItems() ) {
           item1.computeSize(lItems1);
        }
        
        createPlan(lItems1);

    }
    
    
    public static WorkItems createWorkItems() throws WorkItemBadInputException {
        WorkItems lWorkItems = new WorkItems();
        
        WorkItem lWorkItem1 = new WorkItem();
        lWorkItem1.setId(1);
        lWorkItem1.setDescription("Work 1");
        lWorkItem1.setDuration(7);      
        lWorkItems.addItem(lWorkItem1);
        
     
        WorkItem lWorkItem2 = new WorkItem();
        lWorkItem2.setId(2);
        lWorkItem2.setDescription("Work 2");
        lWorkItem2.setDuration(4);        
        lWorkItems.addItem(lWorkItem2);
        
        WorkItem lWorkItem3 = new WorkItem();
        lWorkItem3.setId(5);
        lWorkItem3.setDescription("Work 3");
        lWorkItem3.setDuration(5);       
        
        List<Integer> lItemDependency3 = new ArrayList<Integer>();
        lItemDependency3.add(lWorkItem1.getId());
        lItemDependency3.add(lWorkItem2.getId());
        
        lWorkItem3.setDependencies(lItemDependency3);
        
        lWorkItems.addItem(lWorkItem3);
        
        
        WorkItem lWorkItem4 = new WorkItem();
        lWorkItem4.setId(4);
        lWorkItem4.setDescription("Work 4");
        lWorkItem4.setDuration(1);       
        
        List<Integer> lItemDependency4 = new ArrayList<Integer>();
        lItemDependency4.add(lWorkItem3.getId());

        
        lWorkItem4.setDependencies(lItemDependency4);
        
        lWorkItems.addItem(lWorkItem4);
        
        return lWorkItems;
    }

    public static void createPlan(WorkItems aItems) throws WorkItemBadInputException {
    	
        Collections.sort(aItems.getItems(), new WorkItemComparitor());
        
        int lStart = 1;
        int lDate = 1;
        for (WorkItem item : aItems.getItems()) {
            lDate = lStart + item.getDuration() -1;
            System.out.println(item.getDescription() + " -> : Duration: " + item.getDuration() + " Starts : Day" + lStart + " Ends : Day" + lDate);
            lStart = lDate + 1;
        }
    }
}
