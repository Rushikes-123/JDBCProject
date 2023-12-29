package com.Assigment;

//2. Fetch Patient names admitted after 5th May 2020 and age above 50 and
//store it in ArrayList.

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class HospitalDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");
			System.out.println("Connection Established successfully");

			// Step 3: Create a statement
			Statement statement = con.createStatement();

			// Step 4: Execute the query
			String query = "SELECT pName FROM Patient WHERE admissiondate > '2020-05-05' AND age > 50";
			ResultSet resultSet = statement.executeQuery(query);

			ArrayList<String> patientNames = new ArrayList<>();
			while (resultSet.next()) {
				String patientName = resultSet.getString("pName"); // Correct column name here
				patientNames.add(patientName);
			}

			for (String name : patientNames) {
				System.out.println(name);
			}

			// . Create HashMap with patient id as key and patient Name as value and
			// display it.

			HashMap<Integer, String> patientIdNameMap = new HashMap();

			String sql = "SELECT pid, pName FROM Patient";

			PreparedStatement preparedStatement = con.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int patientId = resultSet.getInt("pid");
				String patientName = resultSet.getString("pName");
				patientIdNameMap.put(patientId, patientName);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
