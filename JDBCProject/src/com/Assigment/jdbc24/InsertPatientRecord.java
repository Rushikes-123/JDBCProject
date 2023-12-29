package com.Assigment.jdbc24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPatientRecord {
	Connection connection ;
	PreparedStatement preparedStatement;

	public void insertPatientRecord() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		System.out.println("Connecting to the database...");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");

		String sql = "INSERT INTO patient (pName, age) VALUES (?, ?)";

		preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

		preparedStatement.setString(1, "John Doe");
		preparedStatement.setInt(2, 75);

		int affectedRows = preparedStatement.executeUpdate();

		if (affectedRows > 0) {
			System.out.println("New record inserted successfully!");
		} else {
			System.out.println("Failed to insert a new record.");
		}

	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		InsertPatientRecord ir=new InsertPatientRecord();
		ir.insertPatientRecord();
	
	}
}
