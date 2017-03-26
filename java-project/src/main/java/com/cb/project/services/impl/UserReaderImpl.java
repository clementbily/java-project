package com.cb.project.services.impl;

import java.util.Optional;
import java.util.Set;

import com.cb.project.constants.IUserConstants;
import com.cb.project.exceptions.UserException;
import com.cb.project.model.business.User;
import com.cb.project.model.data.DataStore;
import com.cb.project.services.IUserReader;

/**
 * @author user
 *
 */
public class UserReaderImpl implements IUserReader {

	/* (non-Javadoc)
	 * @see com.cb.project.services.UserReader#getAllUsers()
	 */
	@Override
	public Set<User> getAllUsers() {
		Set<User> users = DataStore.getUsers();
		return users;
	}

	/* (non-Javadoc)
	 * @see com.cb.project.services.IUserReader#getOneUser(java.lang.Long)
	 */
	@Override
	public User getOneUser(Long id) throws UserException {
		Optional<User> optional = DataStore.getUsers()
			.stream()		
			.filter( account -> account.getId().equals(id))
			.findFirst();
		if (!optional.isPresent()) {
			throw new UserException(IUserConstants.Messages.RESSOURCE_NOT_EXISTS, IUserConstants.Codes.RESSOURCE_NOT_EXISTS);
		}
		return optional.get();
	}
}
