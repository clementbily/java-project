package com.cb.project.services;

import com.cb.project.exceptions.AccountException;
import com.cb.project.exceptions.AppException;
import com.cb.project.model.business.Account;

/**
 * @author user
 *
 */
public interface IAccountCrud {
	
	/**
	 * @param account
	 * @return the new account identifier
	 * @throws AccountException
	 * @throws AppException
	 */
	public Long create(Account account) throws AccountException, AppException;
	/**
	 * @param account
	 * @throws AccountException
	 * @throws AppException
	 */
	public void update (Account account) throws AccountException, AppException;//we shouldn't reuse the object as well. Just quickly
	/**
	 * @param account
	 * @throws AccountException
	 */
	public void delete(Account account) throws AccountException;//we shouldn't reuse the object as well. Just quickly
	/**
	/**
	 * @param account
	 * @param amount
	 * @throws AccountException
	 */
	public void withdraw(Account account, double amount) throws AccountException;
	/**
	 * @param account
	 * @param amount
	 * @throws AccountException
	 */
	public void deposit(Account account, double amount) throws AccountException;
}
