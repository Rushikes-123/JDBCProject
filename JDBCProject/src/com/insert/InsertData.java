package com.insert;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement; 


public class InsertData {

	public static void main(String[] args) {
	try {
		String sql="insert into persons(LastName,  FirstName,Address, City) "+"Values('Jadhav','Rushikesh','Katraj',7000)";
			//Step1: Load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step 2:Established the Connection.
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
	 System.out.println("Connection Established successfully");
	//Step 3:Create the Statement
	Statement stament=con.createStatement();
	
	//Step 4: submit the sql Statement
	boolean isexecuted=stament.execute(sql);
	System.out.println("Insertion is executed properly");
	
	con.close();
	stament.close();
	
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	}

}
