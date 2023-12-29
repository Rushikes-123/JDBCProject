
package com.Assigment.jdbc24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePatientRecords {
	Connection con;
	PreparedStatement preparedStatement;
public void deletepaitentRecord() throws ClassNotFoundException, SQLException {
	   
    Class.forName("com.mysql.cj.jdbc.Driver");

   
    System.out.println("Connecting to the database...");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");

    String sql = "DELETE FROM patients WHERE pid = ?";

    
    preparedStatement = con.prepareStatement(sql);

 
    preparedStatement.setInt(1, 103);

   
    int affectedRows = preparedStatement.executeUpdate();

   
    if (affectedRows > 0) {
        System.out.println("Records deleted successfully!");
    } else {
        System.out.println("No records found for the given patient ID.");
    }
}
   
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	DeletePatientRecords dp=new DeletePatientRecords();
    	dp.deletepaitentRecord();
        
    }
}

