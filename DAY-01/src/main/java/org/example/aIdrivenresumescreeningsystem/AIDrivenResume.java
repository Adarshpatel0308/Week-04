package org.example.aIdrivenresumescreeningsystem;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing Job Role
abstract class JobRole {
    abstract void displayJobRoleDetails();
}

// Software Engineer Role
class SoftwareEngineer extends JobRole {
    private String expertInLanguage;

    public SoftwareEngineer(String expertInLanguage) {
        this.expertInLanguage = expertInLanguage;
    }

    @Override
    void displayJobRoleDetails() {
        System.out.println("Software Engineer - Language Expertise: " + expertInLanguage);
    }
}

// Data Scientist Role
class DataScientist extends JobRole {
    private String dataToolsExpertise;

    public DataScientist(String dataToolsExpertise) {
        this.dataToolsExpertise = dataToolsExpertise;
    }

    @Override
    void displayJobRoleDetails() {
        System.out.println("Data Scientist - Data Tools Expertise: " + dataToolsExpertise);
    }
}

// Product Manager Role
class ProductManager extends JobRole {
    private String productManagementExperience;

    public ProductManager(String productManagementExperience) {
        this.productManagementExperience = productManagementExperience;
    }

    @Override
    void displayJobRoleDetails() {
        System.out.println("Product Manager - Experience in Product Management: " + productManagementExperience);
    }
}

// Generic class Resume<T> to process resumes dynamically for various job roles
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    // Method to process the resume and display the job role details
    public void processResume() {
        System.out.println("Processing resume for the role: ");
        jobRole.displayJobRoleDetails();
    }
}

// Class that performs the resume screening
public class AIDrivenResume {

    // Wildcard method to process resumes of any job role
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.displayJobRoleDetails();  // Display details for any job role in the list
        }
    }

    public static void main(String[] args) {
        // Creating instances of job roles
        SoftwareEngineer softwareEngineer = new SoftwareEngineer("Java, Python, C++");
        DataScientist dataScientist = new DataScientist("Python, R, TensorFlow");
        ProductManager productManager = new ProductManager("Agile, Scrum, Product Lifecycle");

        // Creating Resume objects for each job role
        Resume<SoftwareEngineer> seResume = new Resume<>(softwareEngineer);
        Resume<DataScientist> dsResume = new Resume<>(dataScientist);
        Resume<ProductManager> pmResume = new Resume<>(productManager);

        // Processing individual resumes
        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();

        // Collecting resumes in a list for wildcard method processing
        List<JobRole> allResumes = new ArrayList<>();
        allResumes.add(softwareEngineer);
        allResumes.add(dataScientist);
        allResumes.add(productManager);

        // Using the wildcard method to process multiple job roles dynamically
        System.out.println("Processing all resumes through wildcard method:");
        processResumes(allResumes);
    }
}

