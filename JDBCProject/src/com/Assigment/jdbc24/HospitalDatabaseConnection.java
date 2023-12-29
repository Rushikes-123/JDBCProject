package com.Assigment.jdbc24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HospitalDatabaseConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con;

		Class.forName("com.mysql.cj.jdbc.Driver");

		System.out.println("Connecting to database...");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");

		System.out.println("Connected to the database successfully!");

	}
}
