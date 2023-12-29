package com.Assigment.Scanner;
//Ensure database has INNODB engine.
//Ensure database has on delete cascade and on delete update. Test once by inserting dummy data.
//Write a console application where main menu would have names of tables from above database.
//Read using jdbc, loop, insert using Collection ArrayList etc.
//Choose the table to perform operations on
//1. Regions
//2. Countries
//3. Locations
//4. Departments
//5. Employees
//6. Jobs
//7. Special Menu
//Enter your choice:
//Upon giving choice user would be shown following menu. Suppose user enters choice - 1
//1. Get region name based on id
//2. Add New Region
//3. Delete Region
//4. Update existing region
// 5. Go to main Menu
//Same for Countries and so on.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.Scanner;

	public class DatabaseConsoleApp {

	    

	    public static void main(String[] args) throws SQLException, ClassNotFoundException {
	    	Connection con;
	    	PreparedStatement pstatement;
	    	ResultSet resultSet ;

	    	Class.forName("com.mysql.cj.jdbc.Driver");

	    	System.out.println("Connecting to the database...");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");

	    	
	    String sql=	"SELECT * FROM employees WHERE salary = (SELECT MAX(salary) FROM employees)";

	            createTables(con);  
	            while (true) {
	                int choice = showMainMenu();
	                switch (choice) {
	                    case 1:
	                        performOperations(con, "regions");
	                        break;
	                    case 2:
	                        performOperations(con, "countries");
	                        break;
	                    
	                    case 7:
	                        specialMenu();
	                        break;
	                    case 0:
	                        System.out.println("Exiting the application.");
	                        return;
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            }
	        
	    }

	    public static void createTables(Connection connection) throws SQLException {
	        
	    }

	    public static int showMainMenu() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Main Menu:");
	        System.out.println("1. Regions");
	        System.out.println("2. Countries");
	        System.out.println("3. Locations");
	        System.out.println("4. Departments");
	        System.out.println("5. Employees");
	        System.out.println("6. Jobs");
	        System.out.println("7. Special Menu");
	        System.out.println("0. Exit");
	        System.out.print("Enter your choice: ");
	        return sc.nextInt();
	    }

	    private static void performOperations(Connection connection, String tableName) {
	        while (true) {
	            int choice = showTableMenu(tableName);
	            switch (choice) {
	                case 1:
	                    getRegionById(connection);
	                    break;
	                case 2:
	                    addNewRegion(connection);
	                    break;
	                case 3:
	                    deleteRegion(connection);
	                    break;
	                case 4:
	                    updateRegion(connection);
	                    break;
	                case 5:
	                    return;  
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    public static int showTableMenu(String tableName) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Table Menu: " + tableName);
	        System.out.println("1. Get " + tableName.substring(0, tableName.length() - 1) + " name based on id");
	        System.out.println("2. Add New " + tableName.substring(0, tableName.length() - 1));
	        System.out.println("3. Delete " + tableName.substring(0, tableName.length() - 1));
	        System.out.println("4. Update existing " + tableName.substring(0, tableName.length() - 1));
	        System.out.println("5. Go to Main Menu");
	        System.out.print("Enter your choice: ");
	        return sc.nextInt();
	    }

	    public static void getRegionById(Connection con) {
	       
	    }

	    public static void addNewRegion(Connection connection) {
	        
	    }

	    public static void deleteRegion(Connection connection) {
	        // Implement code to delete a region
	    }

	    public static void updateRegion(Connection connection) {
	        // Implement code to update an existing region
	    }

	    public static void specialMenu() {
	        // Implement code for special menu operations
	    }
	}
