package com.Assigment.jdbc24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePatientRecord {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
         
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            System.out.println("Connecting to the database...");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");

            
            String sql = "DELETE FROM patient WHERE pid = ?";

            preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setInt(1, 105);

            
            int affectedRows = preparedStatement.executeUpdate();

            
            if (affectedRows > 0) {
                System.out.println("Record with ID 5 deleted successfully!");
            } else {
                System.out.println("No record found with ID 5. Nothing deleted.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
