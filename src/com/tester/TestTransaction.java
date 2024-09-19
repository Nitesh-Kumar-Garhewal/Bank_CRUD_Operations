package com.tester;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DbUtil;

public class TestTransaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DbUtil.getDBConnection();

			con.setAutoCommit(false);// byDefault:true

			String str1 = "insert into account values(111,'Shravani',12000,'gauri','gauri@123')";

			Statement stmt = con.createStatement();

			int i = stmt.executeUpdate(str1);//
			System.out.println("First Record Insetred......");

			String str2 = "insert into account values(110,'Gaurav',52000,'gaurav','gaurav@123')";

			i = stmt.executeUpdate(str2);//
			System.out.println("Second Record Insetred......");
			con.commit();// if all dependent query executed successfully
			System.out.println("---commit-----");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			try {
				con.rollback();
				System.out.println("----operations Rollback----------");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
