package com.work.plan.util;

import java.util.Comparator;

import com.work.plan.dto.WorkItem;

public class WorkItemComparitor implements Comparator<WorkItem> {


@Override
public int compare(WorkItem arg0, WorkItem arg1)
{
    // TODO Auto-generated method stub
    return arg0.getSize() - arg1.getSize();
}

}