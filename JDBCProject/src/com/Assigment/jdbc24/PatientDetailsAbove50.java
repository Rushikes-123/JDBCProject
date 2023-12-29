package com.Assigment.jdbc24;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDetailsAbove50 {
	Connection connection ;
	PreparedStatement preparedStatement ;
	ResultSet resultSet ;

	
public void patientDetailsAbove50() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");

	System.out.println("Connecting to the database...");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");

	String sql = "SELECT pid, pName, age FROM patient WHERE age > 40";

	preparedStatement = connection.prepareStatement(sql);

	resultSet = preparedStatement.executeQuery();

	System.out.println("Patients with age above 50:");
	while (resultSet.next()) {
		int pid = resultSet.getInt("pid");
		String pName = resultSet.getString("pName");
		int age = resultSet.getInt("age");

		System.out.println("ID: " + pid + ", Name: " + pName + ", Age: " + age);
	}

}

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PatientDetailsAbove50 pd=new PatientDetailsAbove50();
		pd.patientDetailsAbove50();
		
	}

}
