package com.Assigment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	public static Connection getMysqConnection() throws ClassNotFoundException, SQLException {
		Connection con=null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Establish the connection
        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");
        System.out.println("Connection Established successfully");

		return con1;
		
		
	}
}
