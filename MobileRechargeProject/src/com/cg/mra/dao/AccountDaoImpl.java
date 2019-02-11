package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;

public class AccountDaoImpl implements AccountDao {

	Map<String,Account> accountEntry;
	
	public AccountDaoImpl() {
		super();
		accountEntry = new HashMap<>();
		accountEntry.put("9876543210",new Account("Prepaid","Alok",200));
		accountEntry.put("9876543211",new Account("Prepaid","XYZ",300));
		accountEntry.put("9876543212",new Account("Prepaid","Alok",700));
	}

	@Override
	public Account getAccountDetails(String mobileNumber) {
		Account account = null;
		for(Map.Entry<String, Account> entry : accountEntry.entrySet()) {
			if(entry.getKey().equals(mobileNumber)) {
				account = entry.getValue();
			}
		}
		return account;
	}

	@Override
	public int rechargeAccount(String mobileNumber, double rechargeAmount) {
		accountEntry.get(mobileNumber).setAccountBalance(accountEntry.get(mobileNumber).getAccountBalance()+rechargeAmount);
		return 1;
	}

}
