package com.cb.project.services;

import java.util.Set;

import com.cb.project.exceptions.AccountException;
import com.cb.project.model.business.Account;
import com.cb.project.model.business.User;

public interface IAccountReader {
	public Account getOneAccount(Long id) throws AccountException;
	public Set<Account> getAllAccounts();
	public Set<Account> getAccountsByUser(User user) throws AccountException;
	public Double getUserAccountsBalance(User user) throws AccountException;

}
