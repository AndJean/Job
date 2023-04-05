package com.example.job;

import java.util.ArrayList;

public class JobList {

    private ArrayList<Job> jobList;

    public JobList() {
        this.jobList = new ArrayList<>();
    }

    public  void  addToJobList(Job j) {
        jobList.add(j);
    }


    public int getTotal() {
        return jobList.size();
    }

    public boolean isEmpty()
    {
        return jobList.isEmpty();
    }

    public Job getJob(int i) {
         return jobList.get(i);
    }
}
