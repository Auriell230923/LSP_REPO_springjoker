package org.howard.edu.lsp.finalexam.question2;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        List<Report> reports = new ArrayList<>();

        reports.add(new StudentReport()); // ← MUST be here
        reports.add(new CourseReport());

        for (Report r : reports) {
            r.generateReport();
        }
    }
}