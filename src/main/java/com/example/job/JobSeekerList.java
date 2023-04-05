package com.example.job;

import java.util.ArrayList;

public class JobSeekerList {

    private ArrayList<JobSeeker> jobSeekerList;

    public JobSeekerList() {
        this.jobSeekerList = new ArrayList<>();
    }

    public  void  addToJobSeekerList(JobSeeker j) {
        jobSeekerList.add(j);
    }


    public int getTotal() {
        return jobSeekerList.size();
    }

    public boolean isEmpty()
    {
        return jobSeekerList.isEmpty();
    }

    public JobSeeker getJobSeeker(int i) {
        return jobSeekerList.get(i);
    }
}
