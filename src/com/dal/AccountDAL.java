package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Account;
import com.util.*;

public class AccountDAL {

	private Connection con;

	// constr
	public AccountDAL() {
		con = DbUtil.getDBConnection();// return valid connection
		System.out.println("----connected----");
		System.out.println("----Account DAL created-------");
	}

	// insert
	public int createNewAccount(Account objAct) {
		try {
			String str = "insert into account values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(str);
			pstmt.setInt(1, objAct.getActid());
			pstmt.setString(2, objAct.getName());
			pstmt.setDouble(3, objAct.getBalance());
			pstmt.setString(4, objAct.getUsername());
			pstmt.setString(5, objAct.getPassword());

			// execute it on DB side
			int i = pstmt.executeUpdate();
			System.out.println("inserted " + i + "    Rows");
			return i;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public int editAccountDetails(Account objAct) {

		try {
			String str = "update account set name=?,password=? where actid=?";

			PreparedStatement pstmt = con.prepareStatement(str);
			pstmt.setString(1, objAct.getName());
			pstmt.setString(2, objAct.getPassword());
			pstmt.setInt(3, objAct.getActid());

			int i = pstmt.executeUpdate();
			System.out.println("----updated -----" + i + "   Rows");
			return i;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int deleteAccount(int actId) {
		try {

			String str = "delete from account where actid=" + actId;

			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate(str);
			System.out.println("Deleted   " + i + "    Rows");
			return i;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return 0;

	}

	// select
	public List<Account> getAllAccounts() {
		try {
			List<Account> actList = new ArrayList<Account>();
			String str = "select * from account";

			Statement stmt = con.createStatement();

			ResultSet rset = stmt.executeQuery(str);

			while (rset.next()) {
				Account act = new Account(rset.getInt("actid"), rset.getString("name"), rset.getDouble("balance"),
						rset.getString("username"), rset.getString("password"));

				actList.add(act);

			}
			rset.close();

			return actList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void withdraw(int actid, double amount) {
		//
		String str = "select * from account where actid=" + actid;

		try {

			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(str);

			if (rset.next()) {
				System.out.println("---valid----");

				Account act = new Account(rset.getInt("actid"), rset.getString("name"), rset.getDouble("balance"),
						rset.getString("username"), rset.getString("password"));

				 
				double curBalance = act.getBalance() - amount;
				
				String updateQuery="update account set balance=? where actid=?";
				PreparedStatement pstmt=con.prepareStatement(updateQuery);
				pstmt.setDouble(1, curBalance);
				pstmt.setInt(2, actid);
				
				int i=pstmt.executeUpdate();
				System.out.println("Withdraw Done......on ActId:"+actid +"   CurBalance="+curBalance);
				

			}

			else {
				System.out.println("-----invalid----");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	
	public double getBalanceByID(int actId)
	{
		return 0;
	}
	
	
}
