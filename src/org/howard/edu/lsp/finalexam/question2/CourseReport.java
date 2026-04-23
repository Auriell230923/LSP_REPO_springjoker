package org.howard.edu.lsp.finalexam.question2;

public class CourseReport extends Report {
    private String courseName;
    private int enrollment;

    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    protected String formatHeader() {
        return "Course Report";
    }

    protected String formatBody() {
        return "Course: " + courseName + "\nEnrollment: " + enrollment;
    }

    protected String formatFooter() {
        return "End of Course Report";
    }
}