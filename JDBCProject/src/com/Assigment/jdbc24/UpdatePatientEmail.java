package com.Assigment.jdbc24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatePatientEmail {
	Connection connection;
	Statement statement;

	public void updatepatientemail() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		System.out.println("Connecting to the database...");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");

		statement = connection.createStatement();

		String sql = "UPDATE patient SET email = 'newemail@example.com' WHERE pName = 'Alice Williams'";

		int affectedRows = statement.executeUpdate(sql);

		if (affectedRows > 0) {
			System.out.println("Email address updated successfully!");
		} else {
			System.out.println("Failed to update email address. Patient not found.");
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UpdatePatientEmail up = new UpdatePatientEmail();
		up.updatepatientemail();

	}
}
