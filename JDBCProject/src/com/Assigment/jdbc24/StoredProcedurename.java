package com.Assigment.jdbc24;
//7. Create a Stored Procedure which takes Doctor’s name as input
//parameter and returns his speciality as output parameter. Call this stored
//procedure in java Application. 
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class StoredProcedurename {
    
        Connection con = null;
        CallableStatement cstmt = null;
           
       public void storedProcedurename() throws ClassNotFoundException, SQLException {
    	   Scanner sc=new Scanner(System.in);
    	   System.out.println("Enter the name:");
    	   String docname=sc.nextLine();
    	   Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");

           
           cstmt = con.prepareCall("{call GetSpecialityByDoctorName(?, ?)}");

           
           //String docname = "Dr. Smith"; 
           cstmt.setString(1, docname);

           
           cstmt.registerOutParameter(2,Types.VARCHAR); 

          
           cstmt.execute();

          
           String speciality = cstmt.getString(2);

           System.out.println("Doctor's Name: " + docname);
           System.out.println("Doctor's Speciality: " + speciality);

   }
       public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	   StoredProcedurename spn=new StoredProcedurename();
    	   spn.storedProcedurename();
    	   
	}
           
}
