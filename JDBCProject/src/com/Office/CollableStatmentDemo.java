package com.Office;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;


public class CollableStatmentDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		Connection con;
	

	
			
				con=MyConnection.getMysqConnection();
				CallableStatement cs=con.prepareCall("{call GetCustomerLevel(?,?)}");
				cs.setInt(1, 201);
				cs.registerOutParameter(2, Types.VARCHAR);
				System.out.println(cs.execute());
				System.out.println("customer level is"+cs.getString(2));
		
		
			 
			 
			
	}

}
