package com.Assigment.jdbc24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertAndUpdateRecords {
	 Connection connection ;
     PreparedStatement insertStatement;
     PreparedStatement updateStatement;
   public void insertAndUpdateRecords() throws ClassNotFoundException, SQLException {
	   Class.forName("com.mysql.cj.jdbc.Driver");

       
       System.out.println("Connecting to the database...");
       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");

      
       String Sql = "INSERT INTO patient (pid, pName, age, weight) VALUES (0, ?, ?, ?)";
       insertStatement = connection.prepareStatement(Sql);
       insertStatement.setString(1, "New Patient");
       insertStatement.setInt(2, 40);
       insertStatement.setDouble(3, 80.75);

       int insertResult = insertStatement.executeUpdate();

       
       if (insertResult > 0) {
           System.out.println("New record inserted successfully!");
       } else {
           System.out.println("Failed to insert a new record.");
       }

       
       String updateSql = "UPDATE patient SET weight = ? WHERE pid = ?";
       updateStatement = connection.prepareStatement(updateSql);
       updateStatement.setDouble(1, 55.8); 
       updateStatement.setInt(2, 1); 
       int updateResult = updateStatement.executeUpdate();

       
       if (updateResult > 0) {
           System.out.println("Weight updated successfully!");
       } else {
           System.out.println("Failed to update weight. Record not found.");
       }

}
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	InsertAndUpdateRecords iur=new InsertAndUpdateRecords();
    	iur.insertAndUpdateRecords();
    }
}
