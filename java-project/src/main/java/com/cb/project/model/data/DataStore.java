package com.cb.project.model.data;

import java.util.HashSet;
import java.util.Set;


import com.cb.project.model.business.User;
import com.cb.project.model.business.Account;
public class DataStore {
	private static Set<User> users = new HashSet<>();
	private static  Set<Account> accounts = new HashSet<>();
	public static long accountNumber = 0;
	public static long usertNumber = 0;
	/**
	 * @return the users
	 */
	public static Set<User> getUsers() {
		return users;
	}

	/**
	 * @return the accounts
	 */
	public static Set<Account> getAccounts() {
		return accounts;
	}

	
}
