package com.tq.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStamentDemo {

	public static void main(String[] args) throws SQLException  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb","root","root");
			System.out.println("Connection Established successfully");
			String sql="select employee_id,salary from employees";
			PreparedStatement ps=con.prepareCall(sql);
			ps.setDouble(1, 30000);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getDouble(2));
				System.out.println("-------------------------------");
				ps.clearParameters();
				ps.setDouble(1, 15000);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
