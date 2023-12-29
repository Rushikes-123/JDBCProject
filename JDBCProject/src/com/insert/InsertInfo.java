package com.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertInfo {

	public static void main(String[] args) {
		//Step1: Load the Driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Step 2:Established the Connection.
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			 System.out.println("Connection Established successfully");
			//Step 3:Create the Statement
			 
			PreparedStatement pstament=con.prepareStatement("insert into Employee(username,password)value(?,?)");
			//Step 4: prepare the sql
					pstament.setString(1, "Ram");
					pstament.setString(1, "Diwali");
					pstament.setString(1, "Raj");
					pstament.setString(1, "Java");
					
				int i= pstament.executeUpdate();
				System.out.println("Record is inserted or not"+i);
				//Step 5:release the resource
				con.close();
				pstament.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
