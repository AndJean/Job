package com.example.job;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveJobs(JobList jobList) {

        try {

            File file = new File("Jobs.dat");
            file.createNewFile(); // if file already exists will do nothing

            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream fw = new DataOutputStream(fos);
            fw.writeInt(jobList.getTotal());
            for (int i = 0; i < jobList.getTotal(); i++) {
                Job job = jobList.getJob(i);
                fw.writeUTF(job.getTitle());
                fw.writeUTF(job.getCompany());
                fw.writeInt(job.getSkillList().size());

                for (int j = 0; j < job.getSkillList().size(); j++) {
                    fw.writeUTF(job.getSkillList().get(j).getName());
                }
            }
            fw.flush();
            fw.close();

        } catch (IOException ioException) {
            System.out.println("Error writing file:" + ioException.getMessage());
        }
    }

    public static void readJobs(JobList jobList) {

        try {
            FileInputStream file = new FileInputStream("Jobs.dat");
            DataInputStream fr = new DataInputStream(file);

            int total = fr.readInt();
            for (int j = 0; j < total; j++) {
                String jobName = fr.readUTF();
                String company = fr.readUTF();

                int totalSkills = fr.readInt();
                ArrayList<Skill> skillList = new ArrayList<>();
                for (int k = 0; k < totalSkills; k++) {
                    String skillName = fr.readUTF();
                    Skill skill = new Skill(skillName);
                    skillList.add(skill);
                }
                Job job = new Job(jobName, company, skillList);
                jobList.addToJobList(job);

            }
            fr.close();
        } catch (IOException ioe) {
            System.out.println("No records found");
        }

    }


    public static void saveJobSeekers(JobSeekerList jobSeekerList) {

        try {

            File file = new File("JobSeeker.dat");
            file.createNewFile(); // if file already exists will do nothing

            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream fw = new DataOutputStream(fos);
            fw.writeInt(jobSeekerList.getTotal());
            for (int i = 0; i < jobSeekerList.getTotal(); i++) {
                JobSeeker jobSeeker = jobSeekerList.getJobSeeker(i);
                fw.writeUTF(jobSeeker.getName());
                fw.writeInt(jobSeeker.getAge());
                fw.writeInt(jobSeeker.getSkillList().size());

                for (int j = 0; j < jobSeeker.getSkillList().size(); j++) {
                    fw.writeUTF(jobSeeker.getSkillList().get(j).getName());
                }
            }
            fw.flush();
            fw.close();

        } catch (IOException ioException) {
            System.out.println("Error writing file:" + ioException.getMessage());
        }
    }

    public static void readJobSeekers(JobSeekerList jobSeekerList) {

        try {
            FileInputStream file = new FileInputStream("JobSeeker.dat");
            DataInputStream fr = new DataInputStream(file);

            int total = fr.readInt();
            for (int j = 0; j < total; j++) {
                String seekerName = fr.readUTF();
                int seekerAge = fr.readInt();

                int totalSkills = fr.readInt();
                ArrayList<Skill> skillList = new ArrayList<>();
                for (int k = 0; k < totalSkills; k++) {
                    String skillName = fr.readUTF();
                    Skill skill = new Skill(skillName);
                    skillList.add(skill);
                }
                JobSeeker jobSeeker = new JobSeeker(seekerName, seekerAge, skillList);
                jobSeekerList.addToJobSeekerList(jobSeeker);

            }
            fr.close();
        } catch (IOException ioe) {
            System.out.println("No records found");
        }

    }
}
