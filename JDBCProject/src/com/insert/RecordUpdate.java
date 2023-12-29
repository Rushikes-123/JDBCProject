package com.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RecordUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try {
		//Step1:Load the driver class
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   //Step2:Establish the Connection
    	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
    	   //For single update value
    	   PreparedStatement ps=con.prepareStatement("update employee set username=?were id=?");
    	   
    	   ps.setString(1, "Ashok");
    	   ps.setString(2, "1");
    	   
    	   int i=ps.executeUpdate();
    	   System.out.println("Record Updated:"+i);
    	   
    	   con.close();
    	   ps.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
