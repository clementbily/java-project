package com.cb.project.services.impl;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.cb.project.constants.IAccountConstants;
import com.cb.project.exceptions.AccountException;
import com.cb.project.model.business.Account;
import com.cb.project.model.business.User;
import com.cb.project.model.data.DataStore;
import com.cb.project.services.IAccountReader;

/**
 * @author user
 *
 */
public class AccountReaderImpl implements IAccountReader {
	

	/* (non-Javadoc)
	 * @see com.cb.project.services.IAccountReader#getAllAccounts()
	 */
	@Override
	public Set<Account> getAllAccounts() {
		Set<Account> accounts = DataStore.getAccounts();
		return accounts;
	}

	/* (non-Javadoc)
	 * @see com.cb.project.services.IAccountReader#getAccountsByUser(com.cb.project.model.business.User)
	 */
	@Override
	public Set<Account> getAccountsByUser(User user) throws AccountException  {
		if (user == null) {
			throw new AccountException(IAccountConstants.Messages.MISSING_ATTRIBUTES,IAccountConstants.Codes.MISSING_ATTRIBUTES);
		}
		
		Set<Account> accounts = DataStore.getAccounts();
		Set<Account> userAccounts = accounts.stream()
				.filter( account -> account.getOwner() != null && account.getOwner().equals(user))
				.collect(Collectors.toSet());
		return userAccounts;
	}

	/* (non-Javadoc)
	 * @see com.cb.project.services.IAccountReader#getUserAccountsBalance(com.cb.project.model.business.User)
	 */
	@Override
	public Double getUserAccountsBalance(User user) throws AccountException {
		if (user == null) {
			throw new AccountException(IAccountConstants.Messages.MISSING_ATTRIBUTES,IAccountConstants.Codes.MISSING_ATTRIBUTES);
		}
		
		double sum = DataStore.getAccounts()
			.stream()		
			.filter( account -> account.getOwner() != null && account.getOwner().equals(user))
			.mapToDouble(account -> account.getBalance())
			.sum();
		return sum	;
	}

	/* (non-Javadoc)
	 * @see com.cb.project.services.IAccountReader#getOneAccount(java.lang.Long)
	 */
	@Override
	public Account getOneAccount(Long id) throws AccountException {
		Optional<Account> optional = DataStore.getAccounts()
		.stream()		
		.filter( account -> account.getId().equals(id))
		.findFirst();
		if (!optional.isPresent()) {
			throw new AccountException(IAccountConstants.Messages.RESSOURCE_NOT_EXISTS, IAccountConstants.Codes.RESSOURCE_NOT_EXISTS);
		}
		return optional.get();
	}
}
