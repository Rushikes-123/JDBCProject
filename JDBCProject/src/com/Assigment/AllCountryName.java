package com.Assigment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// WAP using JDBC to select and print all country names.
public class AllCountryName {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");
        System.out.println("Connection Established successfully");

        // Step 3: Create a statement
        Statement statement = con.createStatement();

        // Step 4: Execute the query
        String query = "SELECT Country_name FROM countries";
        ResultSet resultSet = statement.executeQuery(query);

        // Step 5: Process the ResultSet and print country names
        while (resultSet.next()) {
            String countryName = resultSet.getString("Country_name");
            System.out.println(countryName);
            
        }

        // Step 6: Close the resources
        resultSet.close();
        statement.close();
        con.close();
    }
}
