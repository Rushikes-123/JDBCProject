package com.Assigment.jdbc;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResutSetScrollingDemo {

	Connection con;
	Statement st;
	ResultSet rs;
	String sql;

	public ResutSetScrollingDemo() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated constructor stub
		con = MyConnection.getMysqConnection();
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		sql = "select employee_id,first_name,salary,department_id from employees limit 10";
		rs = st.executeQuery(sql);

	}

	public void showScrollingDataInForward() throws SQLException {
		System.out.println("__________________________________________________");
		System.out.println("Emp ID" + "\t" + "Name" + "\t\t" + "Salary" + "\t\tDept No");
		System.out.println("__________________________________________________");

		while (rs.next()) {
			System.out
					.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getDouble(3) + "\t\t" + rs.getInt(4));

		}
	}

	public void showScrollingDataInReverse() throws SQLException {
		System.out.println("__________________________________________________");
		System.out.println("Emp ID" + "\t" + "Name" + "\t\t" + "Salary" + "\t\tDept No");
		System.out.println("__________________________________________________");

		while (rs.previous()) {
			System.out
					.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getDouble(3) + "\t\t" + rs.getInt(4));

		}
	}

	public void showAbsolutepos(int i) throws SQLException {
		// TODO Auto-generated method stub

		rs.absolute(i);
		System.out.println("Record in " + i + "Position ");
		System.out.println("__________________________________________________");
		System.out.println("Emp ID" + "\t" + "Name" + "\t\t" + "Salary" + "\t\tDept No");
		System.out.println("__________________________________________________");
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getDouble(3) + "\t\t" + rs.getInt(4));

		rs.absolute(-5);
		System.out.println("Record in -5 Position ");
		System.out.println("__________________________________________________");
		System.out.println("Emp ID" + "\t" + "Name" + "\t\t" + "Salary" + "\t\tDept No");
		System.out.println("__________________________________________________");
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getDouble(3) + "\t\t" + rs.getInt(4));

		rs.relative(2);
		System.out.println("Record in 2 relative Position ");
		System.out.println("__________________________________________________");
		System.out.println("Emp ID" + "\t" + "Name" + "\t\t" + "Salary" + "\t\tDept No");
		System.out.println("__________________________________________________");
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getDouble(3) + "\t\t" + rs.getInt(4));
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		ResutSetScrollingDemo obj = new ResutSetScrollingDemo();
		obj.showScrollingDataInForward();
		System.out.println();
		obj.showScrollingDataInReverse();
		obj.showAbsolutepos(4);
	}

}
