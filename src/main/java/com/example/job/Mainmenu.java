package com.example.job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mainmenu {

    public static void main(String[] args) {

        JobList jobList = new JobList();
        JobSeekerList jobSeekerList = new JobSeekerList();
        FileHandler.readJobs(jobList);
        FileHandler.readJobSeekers(jobSeekerList);
        char choice;
        do {
            System.out.println();
            System.out.println("1. Add Job");
            System.out.println("2. Display Jobs");
            System.out.println("3. Add Job Seeker");
            System.out.println("4. Display Job Seekers");
            System.out.println("5. Display matching jobs");
            System.out.println("6. Save and Quit");
            System.out.print("Enter choice (1-6): ");
            choice = EasyScanner.nextChar();
            System.out.println();

            switch (choice) {
                case '1':
                    addJob(jobList);
                    break;
                case '2':
                    displayJobs(jobList);
                    break;
                case '3':
                    addJobSeeker(jobSeekerList);
                    break;
                case '4':
                    displayJobSeekers(jobSeekerList);
                    break;
                case '5':
                    displayMatchingJobs(jobList, jobSeekerList);
                    break;
                case '6':
                    saveJobListToFile(jobList, jobSeekerList);
                    break;
                default:
                    System.out.println("Enter 1-6 only");

            }
        } while (choice != '6');

    }

    private static void displayMatchingJobs(JobList jobList, JobSeekerList jobSeekerList) {

        System.out.println("LIST OF JOBS WHERE JOB SKILL MATCHES WITH JOB SEEKER'S SKILL:");

        for (int i = 0; i < jobSeekerList.getTotal(); i++) {

            JobSeeker jobSeeker = jobSeekerList.getJobSeeker(i);
            ArrayList<Skill> skills = jobSeeker.getSkillList();

            for (int j = 0; j < skills.size(); j++) {
                Skill skill = skills.get(j);

                for (int k = 0; k < jobList.getTotal(); k++) {
                    Job job = jobList.getJob(k);
                    for (int l = 0; l < job.getSkillList().size(); l++) {
                        if (job.getSkillList().get(l).getName().trim().equalsIgnoreCase(skill.getName().trim())) {
                            System.out.println("Job seeker: " + jobSeeker.getName());
                            System.out.println("Job seeker skill: " + skill.getName().trim());
                            System.out.println("Matching job title: " + job.getTitle());
                            System.out.println("");
                        }
                    }

                }
            }


        }


    }

    private static void addJobSeeker(JobSeekerList jobSeekerList) {
        System.out.println("Enter name: ");
        String name = EasyScanner.nextString();
        System.out.println("Enter age: ");
        int age = EasyScanner.nextInt();
        System.out.println("Enter skills separated by comma: ");
        String skills = EasyScanner.nextString();

        if (name != null
                && !name.equals("")
                && age != 0
                && skills != null && !skills.equals("")) {


            List<String> skillAsString = Arrays.asList(skills.split(","));

            ArrayList<Skill> skillList = new ArrayList<>();
            for (String skill : skillAsString) {
                Skill s = new Skill(skill);
                skillList.add(s);
            }

            JobSeeker jobSeeker = new JobSeeker(name, age, skillList);
            jobSeekerList.addToJobSeekerList(jobSeeker);
        } else {
            System.out.println("Please enter all the information asked.");
        }

    }


    private static void addJob(JobList jobList) {

        System.out.println("Enter job title: ");
        String title = EasyScanner.nextString();

        System.out.println("Enter company name: ");
        String companyName = EasyScanner.nextString();

        System.out.println("Enter skills separated by comma: ");
        String skills = EasyScanner.nextString();

        if (title != null
                && !title.equals("")
                && companyName != null
                && !companyName.equals("")
                && skills != null && !skills.equals("")) {


            List<String> skillString = Arrays.asList(skills.split(","));

            ArrayList<Skill> skillList = new ArrayList<>();
            for (String skill : skillString) {
                Skill s = new Skill(skill);
                skillList.add(s);
            }

            Job job = new Job(title, companyName, skillList);
            jobList.addToJobList(job);
        } else {
            System.out.println("Please enter all the information asked.");
        }
    }

    private static void displayJobs(JobList jobList) {

        if (jobList.isEmpty()) {
            System.out.println("No jobs to display.");
        } else {
            System.out.println("|Job title|" + "\t\t\t" + "|Company|" + "\t\t\t" + "|Required Skills|" + "\n");
            for (int i = 0; i < jobList.getTotal(); i++) {

                String skills = "";

                int j = 0;
                for (Skill s : jobList.getJob(i).getSkillList()) {
                    skills += s.getName();
                    j++;
                    if (jobList.getJob(i).getSkillList().size() != j) {
                        skills += ", ";
                    }
                }

                System.out.println(jobList.getJob(i).getTitle() + "\t\t\t"
                        + jobList.getJob(i).getCompany() + "\t\t\t" + skills);
            }
        }
    }

    private static void displayJobSeekers(JobSeekerList jobSeekerList) {

        if (jobSeekerList.isEmpty()) {
            System.out.println("No jobs to display.");
        } else {
            System.out.println("|Name|" + "\t\t\t" + "|Age|" + "|\t\t\t" + "|Skills acquired|" + "\n");
            for (int i = 0; i < jobSeekerList.getTotal(); i++) {

                String skills = "";

                int j = 0;
                for (Skill s : jobSeekerList.getJobSeeker(i).getSkillList()) {
                    skills += s.getName();
                    j++;
                    if (jobSeekerList.getJobSeeker(i).getSkillList().size() != j) {
                        skills += ", ";
                    }
                }

                System.out.println(jobSeekerList.getJobSeeker(i).getName() + "\t\t\t"
                        + jobSeekerList.getJobSeeker(i).getAge() + "\t\t\t" + skills);
            }
        }
    }


    private static void saveJobListToFile(JobList jobList, JobSeekerList jobSeekerList) {

        FileHandler.saveJobs(jobList);
        FileHandler.saveJobSeekers(jobSeekerList);
    }


}
