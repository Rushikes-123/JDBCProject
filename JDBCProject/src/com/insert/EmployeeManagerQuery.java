package com.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeManagerQuery {

    public static void main(String[] args) {
        // JDBC database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/testcoursedb";
        String username = "root";
        String password = "root";

        // JDBC variables for managing the connection and executing queries
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(url, username, password);

            // SQL query to select employee names along with their manager names
            String sqlQuery = "SELECT e.employee_name, m.manager_id " +
                              "FROM employees e " +
                              "LEFT JOIN using(manager_id) ";
            // Prepare the SQL statement
            preparedStatement = connection.prepareStatement(sqlQuery);

            // Execute the query and get the result set
            resultSet = preparedStatement.executeQuery();

            // Process the result set and print employee names along with manager names
            while (resultSet.next()) {
                String employeeName = resultSet.getString("employee_name");
                String manager_id = resultSet.getString("manager_id");

                System.out.println("Employee: " + employeeName + ", Manager: " + manager_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


