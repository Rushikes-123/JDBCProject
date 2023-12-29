package com.Assigment.jdbc;

import java.sql.*;
import java.util.*;

public class HospitalDatabaseExample {

    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/testcoursedb";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Task 2: Fetch Patient names admitted after 5th May 2020 and age above 50 and store it in ArrayList
            ArrayList<String> patientNamesList = fetchPatientNames(connection);

            // Task 3: Create HashMap with patient id as key and patient Name as value and display it
            LinkedHashMap<Integer, String> patientIdNameMap = createPatientIdNameMap(connection);

            // Task 4: Create a HashMap with docid as key and list of patients treated by that doctor as value
            LinkedHashMap<Integer, List<String>> doctorPatientsMap = createDoctorPatientsMap(connection);

            // Display results for Task 2 and Task 3
            System.out.println("Patient Names Admitted after 5th May 2020 and Age above 50:");
            for (String patientName : patientNamesList) {
                System.out.println(patientName);
            }

            System.out.println("\n LinkedHashMap with Patient ID as Key and Patient Name as Value:");
            for (int patientId : patientIdNameMap.keySet()) {
                System.out.println("Patient ID: " + patientId + ", Patient Name: " + patientIdNameMap.get(patientId));
            }

            // Display results for Task 4
            System.out.println("\n LinkedHashMap with Doctor ID as Key and List of Patients Treated by that Doctor as Value:");
            for (int docId : doctorPatientsMap.keySet()) {
                System.out.println("Doctor ID: " + docId + ", Patients: " + doctorPatientsMap.get(docId));
            }

            // Task 5: Create a Set of patient ids and sort it in descending order of patient ids
            Set<Integer> patientIdsSet = createAndSortPatientIdsSet(connection);

            System.out.println("\nSet of Patient IDs in Descending Order:");
            for (int patientId : patientIdsSet) {
                System.out.println(patientId);
            }

            // Task 6: Create Stored Procedure to get patient age and name by pid
            callGetPatientInfoProcedure(connection, 1);

            // Task 7: Create Stored Procedure to get doctor speciality by doctor name
            callGetDoctorSpecialityProcedure(connection, "Dr. Smith");

            // Task 8: Create Stored Procedure to get patient details by doctor id
            callGetPatientDetailsByDoctorProcedure(connection, 1);

            // Task 9: Create Function to return count of patients admitted on given date
           // int patientCount = callGetPatientCountFunction(connection, "2023-01-01");
            //System.out.println("\nNumber of Patients Admitted on 2023-01-01: " + patientCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

	// Task 2
    private static ArrayList<String> fetchPatientNames(Connection connection) throws SQLException {
        ArrayList<String> patientNamesList = new ArrayList<>();

        String query = "SELECT pName FROM Patient WHERE admitiondate > '2020-05-05' AND age > 50";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String patientName = resultSet.getString("pName");
                patientNamesList.add(patientName);
            }
        }

        return patientNamesList;
    }

    // Task 3
    private static LinkedHashMap<Integer, String> createPatientIdNameMap(Connection connection) throws SQLException {
        LinkedHashMap<Integer, String> patientIdNameMap = new LinkedHashMap<>();

        String query = "SELECT pid, pName FROM Patient";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int patientId = resultSet.getInt("pid");
                String patientName = resultSet.getString("pName");
                patientIdNameMap.put(patientId, patientName);
            }
        }

        return patientIdNameMap;
    }

    // Task 4
    private static LinkedHashMap<Integer, List<String>> createDoctorPatientsMap(Connection connection) throws SQLException {
        LinkedHashMap<Integer, List<String>> doctorPatientsMap = new  LinkedHashMap<>();

        String query = "SELECT docid, pName FROM Patient";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int doctorId = resultSet.getInt("docid");
                String patientName = resultSet.getString("pName");

                doctorPatientsMap.computeIfAbsent(doctorId, k -> new ArrayList<>()).add(patientName);
            }
        }

        return doctorPatientsMap;
    }

    // Task 5
    private static Set<Integer> createAndSortPatientIdsSet(Connection connection) throws SQLException {
        Set<Integer> patientIdsSet = new TreeSet<>(Comparator.reverseOrder());

        String query = "SELECT pid FROM Patient";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int patientId = resultSet.getInt("pid");
                patientIdsSet.add(patientId);
            }
        }

        return patientIdsSet;
    }

    // Task 6
    private static void callGetPatientInfoProcedure(Connection connection, int pid) throws SQLException {
        String callProcedure = "{CALL GetPatientInfo(?, ?, ?)}";
        try (CallableStatement callableStatement = connection.prepareCall(callProcedure)) {
            callableStatement.setInt(1, pid);
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.registerOutParameter(3, Types.VARCHAR);

            callableStatement.execute();

            int age = callableStatement.getInt(2);
            String name = callableStatement.getString(3);

            System.out.println("\nPatient Info for pid=" + pid + ": Age=" + age + ", Name=" + name);
        }
    }

    // Task 7
    private static void callGetDoctorSpecialityProcedure(Connection connection, String doctorName) throws SQLException {
        String callProcedure = "{CALL GetDoctorSpeciality(?, ?)}";
        try (CallableStatement callableStatement = connection.prepareCall(callProcedure)) {
            callableStatement.setString(1, doctorName);
            callableStatement.registerOutParameter(2, Types.VARCHAR);

            callableStatement.execute();

            String speciality = callableStatement.getString(2);

            System.out.println("\nDoctor Speciality for " + doctorName + ": " + speciality);
        }
    }

    // Task 8
    private static void callGetPatientDetailsByDoctorProcedure(Connection connection, int docid) throws SQLException {
        String callProcedure = "{CALL GetPatientDetailsByDoctor(?, ?, ?, ?)}";
        try (CallableStatement callableStatement = connection.prepareCall(callProcedure)) {
            callableStatement.setInt(1, docid);
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.registerOutParameter(3, Types.VARCHAR);
            callableStatement.registerOutParameter(4, Types.INTEGER);

            try (ResultSet resultSet = callableStatement.executeQuery()) {
                while (resultSet.next()) {
                    int pid = resultSet.getInt("pid");
                    String name = resultSet.getString("pName");
}
            }
        }
    }
}

