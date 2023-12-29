package com.AssigmentHospitalSet2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//5. Create a Set of patient ids and sort it in descending 
//order of patient ids.
public class SetPateintid {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	String sql;
	
	Set<Integer>set=new HashSet<Integer>();
	
	public void setpateintid() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		System.out.println("Connecting to the database...");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");
		sql = "SELECT docid, docname, Speciality FROM doctor";
		pst = con.prepareStatement(sql);

		rs = pst.executeQuery();
		
	
		System.out.print("Sorted Patient IDs (Descending Order): ");
		for (Integer patientId :set) {
		    System.out.print(patientId + " ");
		}
		System.out.println();
      Iterator<Integer>itr=set.iterator();
         while(itr.hasNext()) {
        	 System.out.println(itr.next());
         }
       
	}

}
