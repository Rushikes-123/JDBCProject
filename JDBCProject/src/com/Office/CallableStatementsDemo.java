package com.Office;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementsDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = MyConnection.getMysqConnection();

        
        int employeeNumber = 123; 
        CallableStatement cs2 = con.prepareCall("{? = call getNum(?)}");
        cs2.registerOutParameter(1, Types.INTEGER);
        
        
        cs2.setInt(2, employeeNumber);
        
        cs2.execute();
        System.out.println("Result of getNum function: " + cs2.getInt(1));

        con.close();
    }
}
