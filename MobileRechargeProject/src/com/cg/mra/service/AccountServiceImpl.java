package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;

public class AccountServiceImpl implements AccountService {

	AccountDao accountdao;
	
	public AccountServiceImpl(AccountDao accountdao) {
		super();
		this.accountdao = accountdao;
	}

	@Override
	public Account getAccountDetails(String mobileNumber) throws Exception {
		Account account = accountdao.getAccountDetails(mobileNumber);
		if(account==null) {
			throw new Exception("Given account is not exist");
		}
		return account;
	}

	@Override
	public int rechargeAccount(String mobileNumber, double rechargeAmount) throws Exception {
		Account account = accountdao.getAccountDetails(mobileNumber);
		if(account!=null) {
			return accountdao.rechargeAccount(mobileNumber, rechargeAmount);
		}
		throw new Exception("Cannot recharge account as given mpbile number does not exist");
	}

}
