package org.howard.edu.lsp.finalexam.question2;

public class StudentReport extends Report {
    private String studentName;
    private double gpa;

    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    protected String formatHeader() {
        return "Student Report";
    }

    protected String formatBody() {
        return "Student Name: " + studentName + "\nGPA: " + gpa;
    }

    protected String formatFooter() {
        return "End of Student Report";
    }
}