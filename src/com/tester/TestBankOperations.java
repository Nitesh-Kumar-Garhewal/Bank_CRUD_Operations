package com.tester;

import java.util.List;
import java.util.Scanner;

import com.dal.AccountDAL;
import com.pojo.Account;

public class TestBankOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("1:show all acts 2: add 3:update 4:delete 5:withdraw 6:deposite 7:exit");
		int ch;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("enter Choice:");
			ch = sc.nextInt();

			AccountDAL actDao = new AccountDAL();// connection

			switch (ch) {

			case 1:
				System.out.println("-----All Accounts Details------");
				List<Account> listActs = actDao.getAllAccounts();
				// listActs.forEach(a->System.out.println(a));
				// or

				for (Account act : listActs) {
					System.out.println(act);
				}

				break;
			case 2:
				System.out.println("-----Add New Account------");
				System.out.println("ActId  Name Balance username password");
				int id = sc.nextInt();
				String nm = sc.next();
				double balance = sc.nextDouble();
				String un = sc.next();
				String pwd = sc.next();

				Account act = new Account(id, nm, balance, un, pwd);
				int i = actDao.createNewAccount(act);
				if (i == 1) {
					System.out.println("Created A new Account:" + act);
				}

				break;
			case 3:
				System.out.println("-----Edit/Update Account------");
				System.out.println("Actid Name  passorwd");

				id = sc.nextInt();
				nm = sc.next();
				pwd = sc.next();
				Account actToUpdate=new Account(id, nm,  pwd);
				actDao.editAccountDetails(actToUpdate);

				break;
			case 4:
				//Lab Task
				
				System.out.println("Enter ActId");
				actDao.deleteAccount(sc.nextInt());
				
				System.out.println("-----Delete/Remove Account------");
				break;
			case 5:
				System.out.println("-----Withdraw From Account------");
				
				System.out.println("Enter ActId  amount to withdraw");
				id=sc.nextInt();
				double amount=sc.nextDouble();
				actDao.withdraw(id, amount);
						
				break;
			case 6:
				break;

			}

		} while (ch != 7);

	}

}
