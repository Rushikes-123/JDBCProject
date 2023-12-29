package com.AssigmentHospitalSet2;

//2. Fetch Patient names admitted after 5th May 2020 and age above 50 and
//store it in ArrayList.

import java.sql.*;
import java.util.ArrayList;

import java.util.LinkedHashMap;

public class HospitalDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");
			System.out.println("Connection Established successfully");

			Statement statement = con.createStatement();

			String query = "SELECT pName,age,admissiondate FROM Patient WHERE admissiondate > '2020-05-05' AND age > 50";
			ResultSet resultSet = statement.executeQuery(query);

			ArrayList<String> patientNames = new ArrayList<>();
			while (resultSet.next()) {
				String patientName = resultSet.getString("pName");
				patientNames.add(patientName);

			}

			for (String name : patientNames) {
				System.out.println(name);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
