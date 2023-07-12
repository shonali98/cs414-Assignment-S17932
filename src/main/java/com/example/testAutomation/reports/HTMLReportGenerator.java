package com.example.testautomation.reports;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLReportGenerator {
    private BufferedWriter bufferedWriter;

    public HTMLReportGenerator(String filePath) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startReport(String reportTitle) {
        try {
            bufferedWriter.write("<html>");
            bufferedWriter.write("<head>");
            bufferedWriter.write("<title>" + reportTitle + "</title>");
            bufferedWriter.write("</head>");
            bufferedWriter.write("<body>");
            bufferedWriter.write("<h1>" + reportTitle + "</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addSection(String sectionTitle) {
        try {
            bufferedWriter.write("<h2>" + sectionTitle + "</h2>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addParagraph(String text) {
        try {
            bufferedWriter.write("<p>" + text + "</p>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTable(String[][] tableData) {
        try {
            bufferedWriter.write("<table border='1'>");
            for (String[] row : tableData) {
                bufferedWriter.write("<tr>");
                for (String cell : row) {
                    bufferedWriter.write("<td>" + cell + "</td>");
                }
                bufferedWriter.write("</tr>");
            }
            bufferedWriter.write("</table>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void endReport() {
        try {
            bufferedWriter.write("</body>");
            bufferedWriter.write("</html>");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
