package com.cb.project.services.impl;

import java.util.Set;

import com.cb.project.constants.IAccountConstants;
import com.cb.project.exceptions.AccountException;
import com.cb.project.exceptions.AppException;
import com.cb.project.exceptions.UserException;
import com.cb.project.model.business.Account;
import com.cb.project.model.data.DataStore;
import com.cb.project.services.IAccountCrud;
import com.cb.project.services.IAccountReader;
import com.cb.project.services.IUserReader;
import com.cb.project.validator.Validator;
import com.cb.project.validator.impl.AccountCreationValidator;
import com.cb.project.validator.impl.AccountUpdateValidator;

/**
 * @author user
 *
 */
public class AccountCrudImpl implements IAccountCrud {
	
	private IUserReader userService = new UserReaderImpl();
	private IAccountReader readerService = new AccountReaderImpl();
	
	/* (non-Javadoc)
	 * @see com.cb.project.services.AccountCrud#create(com.cb.project.model.business.Account)
	 */
	@Override
	public Long create(Account account) throws AppException {
		Set<Account> accounts = DataStore.getAccounts();
	
		Validator<Account> validator = new AccountCreationValidator();
		validator.validate(account);
		if (account != null) {
			
			account.setId(++DataStore.accountNumber);
			checkOwner(account);

			accounts.add(account);
			return account.getId();
		}
		return null;
	}



	/* (non-Javadoc)
	 * @see com.cb.project.services.AccountCrud#update(com.cb.project.model.business.Account)
	 */
	@Override
	public void update(Account account) throws AppException {
		
		Set<Account> accounts = DataStore.getAccounts();
		Validator<Account> validator = new AccountUpdateValidator();
		validator.validate(account);
		if (account != null) {
			checkOwner(account);
			Account actual  = readerService.getOneAccount(account.getId());
			boolean isRemove = accounts.remove(account);//quick but dirty should not be done with a real DB
			if (isRemove) {
				account.setBalance(actual.getBalance());//just set the current balance value
				accounts.add(account);
			}
			else {
				throw new AccountException(IAccountConstants.Messages.RESSOURCE_NOT_EXISTS, IAccountConstants.Codes.RESSOURCE_NOT_EXISTS);
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see com.cb.project.services.AccountCrud#delete(com.cb.project.model.business.Account)
	 */
	@Override
	public void delete(Account account) throws AccountException {
		Set<Account> accounts = DataStore.getAccounts();
		if (account != null) {
			boolean isRemove = accounts.remove(account);
			if (!isRemove) {
				throw new AccountException(IAccountConstants.Messages.RESSOURCE_NOT_EXISTS, IAccountConstants.Codes.RESSOURCE_NOT_EXISTS);
			}	
		}
	}
	
	
	/**
	 * @param account
	 * @throws AccountException
	 */
	private void checkOwner(Account account) throws AccountException {
		try {
			userService.getOneUser(account.getOwner().getId());//reuse the service
		} catch (UserException e) {
			throw new AccountException(IAccountConstants.Messages.ACCOUNT_USER_NOT_EXISTS, IAccountConstants.Codes.ACCOUNT_USER_NOT_EXISTS);
		}
	}
	
	
	
	/**
	 * @param account
	 * @throws AccountException
	 */
	private void checkNumber(double d) throws AccountException {
		if (d <= 0) {
			throw new AccountException(IAccountConstants.Messages.POSITIVE_NUMBER, IAccountConstants.Codes.POSITIVE_NUMBER);
		} 
	}



	/* (non-Javadoc)
	 * @see com.cb.project.services.AccountCrud#cashDrawl(com.cb.project.model.business.Account, double)
	 */
	@Override
	public void withdraw(Account account, double amount) throws AccountException {
		Account realAccount = readerService.getOneAccount(account.getId());
		checkNumber(amount);
		double newBalance = realAccount.getBalance() - amount;
		if (newBalance <0) {
			throw new AccountException(IAccountConstants.Messages.INSUFFICIENT_BALANCE, IAccountConstants.Codes.INSUFFICIENT_BALANCE);
		}		
		realAccount.setBalance(newBalance);
	}



	/* (non-Javadoc)
	 * @see com.cb.project.services.AccountCrud#deposite(com.cb.project.model.business.Account, double)
	 */
	@Override
	public void deposit(Account account, double amount) throws AccountException {
		Account realAccount = readerService.getOneAccount(account.getId());	
		checkNumber(amount);
		realAccount.setBalance(realAccount.getBalance() + amount);	
	}



}
