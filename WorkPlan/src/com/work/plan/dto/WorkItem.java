package com.work.plan.dto;
import java.util.ArrayList;
import java.util.List;

import com.work.plan.exception.WorkItemNotFoundException;

public class WorkItem
{


    private int id;
    private String description;
    private int duration;
    private List<Integer> dependencies = new ArrayList<Integer>();
    private int size;
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public int getDuration()
    {
        return duration;
    }
    public void setDuration(int duration)
    {
        this.duration = duration;
    }
    public List<Integer> getDependencies()
    {
        return dependencies;
    }
    public void setDependencies(List<Integer> dependencies)
    {
        this.dependencies = dependencies;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public void computeSize(WorkItems aItems) throws WorkItemNotFoundException
    {
        int lSize = this.getDuration();
        

        if(null != this.dependencies && !this.dependencies.isEmpty()) {
            for (Integer a : this.dependencies) {
                WorkItem lWorkItem = aItems.getItem(a);
                lSize +=  lWorkItem.getSize();
            }
        }
        
        this.size = lSize;
        
    }
    
}


