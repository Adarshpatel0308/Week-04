package org.example.multileveluniversitycoursemanagementsystem;

import java.util.ArrayList;
import java.util.List;

//Abstract class for the courseType
abstract class CourseType {

    abstract void displayDetails();

}
//ExamCourse class extends the abstract class CourseType
class ExamCourse extends CourseType {
    private String mathCourse;
    private String scienceCourse;

    public ExamCourse(String mathCourse, String scienceCourse) {
        this.mathCourse = mathCourse;
        this.scienceCourse = scienceCourse;
    }

    public String getMathCourse() {
        return mathCourse;
    }

    public String getScienceCourse() {
        return scienceCourse;
    }

    @Override
    void displayDetails() {
        System.out.println("The Name of the ExamCourse First : " + mathCourse);
        System.out.println("The Name of the ExamCourse Second : " + scienceCourse);
    }
}
//AssignmentCourses extends abstract class CourseType
class AssignmentCourse extends CourseType {
    private String biologyAssignment;

    public AssignmentCourse(String biologyAssignment) {
        this.biologyAssignment = biologyAssignment;
    }

    public String getAssignmentName() {
        return biologyAssignment;
    }

    @Override
    void displayDetails() {
        System.out.println("The Name of the Assignment Course : " + biologyAssignment);
    }
}
//Class ResearchCourse extends CourseType abstract class
class ResearchCourse extends CourseType {
    private String researchOnFossils;

    public ResearchCourse(String researchOnFossils) {
        this.researchOnFossils = researchOnFossils;
    }

    public String getResearchName() {
        return researchOnFossils;
    }

    @Override
    void displayDetails() {
        System.out.println("The name of the Research Course : " + researchOnFossils);
    }
}
//Generic class which extends CourseType
class Course<T extends CourseType> {
    List<T> courses;

    public Course() {
        this.courses = new ArrayList<>(); // Initialize the list
    }
    //Method to add the courses in the list
    public void add(T course) {
        courses.add(course);
    }
    //Method to get the List
    public List<T> getList() {
        return courses;
    }
    //Method to get the all details
    public void getAllDetails(List<? extends CourseType> lists) {
        for (CourseType c : lists) {
            c.displayDetails();
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {

        // Create courses with specific types
        Course<ExamCourse> exam = new Course<>();
        Course<AssignmentCourse> assignment = new Course<>();
        Course<ResearchCourse> research = new Course<>();

        // Add courses to the respective lists
        exam.add(new ExamCourse("Differentiation", "Integration"));
        assignment.add(new AssignmentCourse("Functions Of Viens"));
        research.add(new ResearchCourse("How Fossils Generates"));

        // Get all details for each course
        System.out.println("Exam Courses:");
        exam.getAllDetails(exam.getList());

        System.out.println("Assignment Courses:");
        assignment.getAllDetails(assignment.getList());

        System.out.println("Research Courses:");
        research.getAllDetails(research.getList());
    }
}
