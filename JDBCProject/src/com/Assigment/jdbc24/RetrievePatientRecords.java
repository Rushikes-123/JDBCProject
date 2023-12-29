package com.Assigment.jdbc24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrievePatientRecords {
	Connection connection ;
	Statement statement;
	ResultSet resultSet ;

	public void retrievePatientRecords() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		System.out.println("Connecting to the database...");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");

		statement = connection.createStatement();

		String sql = "SELECT * FROM patient";

		resultSet = statement.executeQuery(sql);

		System.out.println("Forward Order:");
		while (resultSet.next()) {
			int pid = resultSet.getInt("pid");
			String pName = resultSet.getString("pName");
			int age = resultSet.getInt("age");

			System.out.println("ID: " + pid + ", Name: " + pName + ", Age: " + age);
		}
		resultSet.last();

		System.out.println("\nReverse Order:");
		while (resultSet.previous()) {
			int pid = resultSet.getInt("pid");
			String pName = resultSet.getString("pName");
			int age = resultSet.getInt("age");

			System.out.println("ID: " + pid + ", Name: " + pName + ", Age: " + age);
		}

	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		RetrievePatientRecords rp=new RetrievePatientRecords();
		rp.retrievePatientRecords();
		
	}
}
