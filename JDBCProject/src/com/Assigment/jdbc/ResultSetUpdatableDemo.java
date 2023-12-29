package com.Assigment.jdbc;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetUpdatableDemo {

		Connection  con;
		Statement st;
		ResultSet rs;
		String sql;
		public ResultSetUpdatableDemo() throws SQLException, ClassNotFoundException {
			// TODO Auto-generated constructor stub
			
			con=MyConnection.getMysqConnection();
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			sql="select employee_id,first_name,last_name,salary,department_id from employees limit 10";
			rs=st.executeQuery(sql);
			
		}
		public void deleteRecord(int pos) throws SQLException
		{
			rs.absolute(pos);
			rs.deleteRow();
			
		}
		public void updateRecord(int pos) throws SQLException
		{
			rs.absolute(pos);
			rs.updateDouble(3, 99000);
			rs.updateRow();
			
		}
		public void insertData() throws SQLException
		{
			rs.moveToInsertRow();
			rs.updateInt(1, 422);
			rs.updateString(2,"Raj");
			rs.updateString(3,"Sharma");
			rs.updateDouble(4,90000);
			rs.updateInt(5, 90);
			rs.insertRow();
		}
		public void showData() throws SQLException
		{
			System.out.println("__________________________________________________");
			System.out.println("Emp ID" +"\t"+"Name"+"\t\t"+"LastName"+"\t\t"+"Salary"+"\t\tDept No");
			System.out.println("__________________________________________________");
			rs.beforeFirst();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+rs.getDouble(4)+"\t\t"+rs.getInt(5));
				
			}
		}
		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			// TODO Auto-generated method stub\
			
			ResultSetUpdatableDemo obj=new ResultSetUpdatableDemo();
			//obj.deleteRecord(5);
			obj.showData();
		//	obj.updateRecord(5);
		//	obj.showData();
			obj.insertData();
			obj.showData();
		}

	}


