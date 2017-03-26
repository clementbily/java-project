package com.cb.project.services.impl;

import java.util.Set;

import com.cb.project.constants.IUserConstants;
import com.cb.project.exceptions.AppException;
import com.cb.project.exceptions.UserException;
import com.cb.project.model.business.User;
import com.cb.project.model.data.DataStore;
import com.cb.project.services.IUserCrud;
import com.cb.project.validator.Validator;
import com.cb.project.validator.impl.UserCreationValidator;
import com.cb.project.validator.impl.UserUpdateValidator;

/**
 * @author user
 *
 */
public class UserCrudImpl implements IUserCrud {

	/* (non-Javadoc)
	 * @see com.cb.project.services.UserCrud#create(com.cb.project.model.business.User)
	 */
	@Override
	public Long create(User user) throws AppException {
		Set<User> users = DataStore.getUsers();
		Validator<User> validator = new UserCreationValidator();
		if (user != null) {	
			validator.validate(user);
			user.setId(++DataStore.usertNumber);
			users.add(user);
			return user.getId();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cb.project.services.UserCrud#update(com.cb.project.model.business.User)
	 */
	@Override
	public void update(User user) throws AppException {
		Validator<User> validator = new UserUpdateValidator();
		validator.validate(user);
		Set<User> users = DataStore.getUsers();
		if (user != null) {
			boolean isRemove = users.remove(user);
			if (isRemove) {
				users.add(user);//bad for quick reason we should get the current value and set the property
			}
			else {
				throw new UserException(IUserConstants.Messages.RESSOURCE_NOT_EXISTS, IUserConstants.Codes.RESSOURCE_NOT_EXISTS);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.cb.project.services.UserCrud#delete(com.cb.project.model.business.User)
	 */
	@Override
	public void delete(User user) throws UserException {
		Set<User> users = DataStore.getUsers();
		if (user != null) {
			boolean isRemove = users.remove(user);
			if (!isRemove) {
				throw new UserException(IUserConstants.Messages.RESSOURCE_NOT_EXISTS, IUserConstants.Codes.RESSOURCE_NOT_EXISTS);
			}
		}
	}
}
