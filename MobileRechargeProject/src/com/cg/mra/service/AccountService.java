package com.cg.mra.service;

import com.cg.mra.beans.Account;

public interface AccountService {
	public Account getAccountDetails(String mobileNumber) throws Exception;
	public int rechargeAccount(String mobileNumber,double rechargeAmount) throws Exception;
}
