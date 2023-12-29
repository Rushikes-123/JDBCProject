package com.Assigment;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Hospital {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");
            System.out.println("Connection Established successfully");

            // Fetch Patient names admitted after 5th May 2020 and age above 50
            ArrayList<String> patientNames = fetchPatients(con);

            
            for (String name : patientNames) {
                System.out.println(name);
            }

            // Create HashMap with patient id as key and patient Name as value and display it.
            HashMap<Integer, String> patientIdNameMap = fetchPatientIdNameMap(con);

            for (Integer patientId : patientIdNameMap.keySet()) {
                String patientName = patientIdNameMap.get(patientId);
                System.out.println("Patient ID: " + patientId + ", Patient Name: " + patientName);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

  public static ArrayList<String> fetchPatients(Connection con) throws SQLException {
        // Step 3: Create a statement
        Statement statement = con.createStatement();

        // Step 4: Execute the query
        String query = "SELECT pName FROM Patient WHERE admissiondate > '2020-05-05' AND age > 50";
        ResultSet resultSet = statement.executeQuery(query);

        // Step 5: Process the result set and store in ArrayList
        ArrayList<String> patientNames = new ArrayList<>();
        while (resultSet.next()) {
            String patientName = resultSet.getString("pName");
            patientNames.add(patientName);
        }

        return patientNames;
    }

   public static HashMap<Integer, String> fetchPatientIdNameMap(Connection con) throws SQLException {
        HashMap<Integer, String> patientIdNameMap = new HashMap<>();

        String sql = "SELECT pid, pName FROM Patient";

        PreparedStatement preparedStatement = con.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int patientId = resultSet.getInt("pid");
            String patientName = resultSet.getString("pName");
            patientIdNameMap.put(patientId, patientName);
        }

        return patientIdNameMap;
    }
}
