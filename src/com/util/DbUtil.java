package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	
	public static  Connection getDBConnection()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("---Driver Class Get Loaded......");

		// JDBC
		//
		// Step1:Make Connection

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");

		System.out.println("---connected with DB");
		return con;//valid connection
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		 return null;//in case of any exception
	}

	
	
	
}
