package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {

	private static Scanner sc = new Scanner(System.in);
	private static AccountDao accountdao = new AccountDaoImpl();
	private static AccountService accountService = new AccountServiceImpl(accountdao);

	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {
		int choice;
		while (true) {
			System.out.println("1.Account balance enquiry");
			System.out.println("2.Recharge Account");
			System.out.println("3.Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				accountBalanceEnq();
				break;
			case 2:
				rechargeAccount();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong choice");
			}
		}

	}

	private static void accountBalanceEnq() {
		String mob = sc.next();
		try {
			System.out.println("You current balance : " + accountService.getAccountDetails(mob).getAccountBalance());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void rechargeAccount() {
		String mob = sc.next();
		double balance = sc.nextDouble();
		try {
			if (accountService.rechargeAccount(mob, balance) == 1) {
				System.out.println("Your account sucessfully recharged");
				Account account = accountService.getAccountDetails(mob);
				System.out.println(
						"Hello " + account.getCustomerName() + " avilable balance is : " + account.getAccountBalance());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
