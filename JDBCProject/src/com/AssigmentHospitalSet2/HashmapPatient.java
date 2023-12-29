package com.AssigmentHospitalSet2;
//3. Create HashMap with patient id as key and patient Name as value and
//display it.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashmapPatient {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	String sql;
	  HashMap<Integer, String>map=new HashMap<Integer, String>();
 		
       public void HashmapPaitentDetail() throws ClassNotFoundException, SQLException {
    	   Class.forName("com.mysql.cj.jdbc.Driver");

   		System.out.println("Connecting to the database...");
   		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");
         sql="select pid,pname from patients";
         pst = con.prepareStatement(sql);
         
         rs = pst.executeQuery();
         
         while (rs.next()) {
             int patientId = rs.getInt("pid");
             String patientName = rs.getString("pname");
             map.put(patientId, patientName);
         }
     
       }
       public void showMapData() {
    	Set<Entry<Integer,String>>hset=map.entrySet();
    	Iterator<Entry <Integer,String>>itr=hset.iterator();
    	while(itr.hasNext()) {
    		System.out.println(itr.next());
    	}
       }
       public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	   HashmapPatient hp=new HashmapPatient();
    	   hp.HashmapPaitentDetail();
		    hp.showMapData();
	}
}
