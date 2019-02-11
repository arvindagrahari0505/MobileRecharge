package com.cg.mra.dao;

import com.cg.mra.beans.Account;

public interface AccountDao {
	public Account getAccountDetails(String mobileNumber);
	public int rechargeAccount(String mobileNumber,double rechargeAmount);
}
