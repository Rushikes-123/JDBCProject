package com.Assigment.jdbc24;

//6. Create Stored Procedure in database which takes pid as input parameter
//and returns patient age and name as output parameters. Call this
//procedure through java application.
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CallStoredProcedure {
	Connection con;
	CallableStatement cstmt;

	public void callstroprocedure() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id:");
		int pid = sc.nextInt();

		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");

		cstmt = con.prepareCall("{call GetPatientInfo(?, ?, ?)}");

		// int pid = 101;
		cstmt.setInt(1, pid);

		cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
		cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);

		cstmt.execute();

		int age = cstmt.getInt(2);
		String pname = cstmt.getString(3);

		System.out.println("Patient ID: " + pid);
		System.out.println("Patient Age: " + age);
		System.out.println("Patient Name: " + pname);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		CallStoredProcedure csp = new CallStoredProcedure();
		csp.callstroprocedure();
	}
}
