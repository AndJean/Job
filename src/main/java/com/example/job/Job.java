package com.example.job;

import java.util.ArrayList;
import java.util.List;

public class Job {

    private String title;
    private String company;
    private ArrayList<Skill> skillList;

    public Job(String title, String company, ArrayList<Skill> skillList) {
        this.title = title;
        this.company = company;
        this.skillList = skillList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;
    }
}
