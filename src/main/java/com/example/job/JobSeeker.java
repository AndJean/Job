package com.example.job;

import java.util.ArrayList;

public class JobSeeker {

    private String name;
    private int age;
    private ArrayList<Skill> skillList;

    public JobSeeker(String name, int age, ArrayList<Skill> skillList) {
        this.name = name;
        this.age = age;
        this.skillList = skillList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;

    }
}
