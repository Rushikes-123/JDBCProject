package com.Assigment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.Assigment.jdbc.MyConnection;

public class EmployeeDeptMapDemo {

	Connection con;
	ResultSet rsemp,rsdept;
	Statement stemp,stdept;
	HashMap<String,ArrayList<String>>map=new HashMap<>();
	public EmployeeDeptMapDemo() throws SQLException, ClassNotFoundException {
		con = MyConnection.getMysqConnection();
		stemp = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rsemp = stemp.executeQuery("select * from employees");
		
		stdept = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rsdept = stdept.executeQuery("select * from departments");
		
	}
	public void cratemap() throws SQLException {
		int deptno=0;
		String dname=null;
		while(rsdept.next()) {
			deptno=rsdept.getInt(1);
			ArrayList<String>enames=new ArrayList<>();
			rsemp.beforeFirst();
			while(rsemp.next())
			{
				if(rsemp.getInt(11)==deptno)
				{
					dname=rsdept.getString(2);
					enames.add(rsemp.getString(2));
				}
				
			}
			map.put(dname, enames);	
			
		}
		
	}
		public void show() {
			Set<Entry<String,ArrayList<String>>>set=map.entrySet();
			Iterator<Entry<String,ArrayList<String>>>itr=set.iterator();
			while(itr.hasNext())
			{
				Entry<String, ArrayList<String>> ele	=itr.next();
				if(ele.getValue().size()>0)
				{
					System.out.println(ele.getKey());
					System.out.println(ele.getValue());
				
			}
			}
		}
			public static void main(String[] args) throws SQLException, ClassNotFoundException {
				// TODO Auto-generated method stub
				EmployeeDeptMapDemo obj=new EmployeeDeptMapDemo();
				obj.cratemap();
				obj.show();
			

		
	}
	
}
