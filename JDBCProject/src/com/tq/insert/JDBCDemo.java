package com.tq.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			String sql="select * from departments";
			//Step1: Load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step 2:Established the Connection.
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb","root","root");
	System.out.println("Connection Established successfully");
	//Step 3:Create the Statement
	Statement stament=con.createStatement();
	ResultSet rs=stament.executeQuery(sql);
//	while(rs.next()) {
//		System.out.println("Department_id:"+rs.getInt(1));
//		System.out.println("Department_Name:"+rs.getString(2));
//		System.out.println("MANAGER_ID:"+rs.getInt(3));
//		System.out.println("LOCATION_ID:"+rs.getInt(4));
//		System.out.println("--------------------------------------");
//	}
//	  sql = "insert into departments (DEPARTMENT_ID,Department_Name,MANAGER_ID,LOCATION_ID ) VALUES (245,'Hr', 107,2300)";
	sql="delete from departments where department_id=270";
	sql = "UPDATE departments SET Department_Name = 'NewHr', MANAGER_ID = 108, LOCATION_ID = 2400 WHERE DEPARTMENT_ID = 250";

	
	int cnt=stament.executeUpdate(sql);
	System.out.println(cnt+"insert the data");
	System.out.println("delete succesfully!");
	System.out.println("update succesfully!");
	}

}
