package com.cb.project.validator.impl;

import com.cb.project.constants.IUserConstants;
import com.cb.project.exceptions.UserException;
import com.cb.project.model.business.User;
import com.cb.project.validator.Validator;

/**
 * @author user
 *
 */
public class UserCreationValidator implements Validator<User> {
	/* (non-Javadoc)
	 * @see com.cb.project.validator.Validator#validate(java.lang.Object)
	 */
	@Override
	public void validate(User user) throws UserException {
		if (user == null
			 || user.getAddress() == null
			|| user.getFirstName() == null
			|| user.getLastName() == null
			|| user.getPhone() == null ) {
			throw new UserException(IUserConstants.Messages.MISSING_ATTRIBUTES, IUserConstants.Codes.MISSING_ATTRIBUTES);
		}
		
	}

}
