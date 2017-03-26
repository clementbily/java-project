package com.cb.project.validator.impl;

import com.cb.project.constants.IAccountConstants;
import com.cb.project.exceptions.AccountException;
import com.cb.project.model.business.Account;
import com.cb.project.validator.Validator;

/**
 * @author user
 *
 */
public class AccountCreationValidator implements Validator<Account> {
	/* (non-Javadoc)
	 * @see com.cb.project.validator.Validator#validate(java.lang.Object)
	 */
	@Override
	public void validate(Account account) throws AccountException {
		if (account == null
				 || account.getCreation() == null) {
				throw new AccountException(IAccountConstants.Messages.MISSING_ATTRIBUTES, IAccountConstants.Codes.MISSING_ATTRIBUTES);
			}
	}

}
