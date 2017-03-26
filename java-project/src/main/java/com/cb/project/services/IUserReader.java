package com.cb.project.services;

import java.util.Set;

import com.cb.project.exceptions.UserException;
import com.cb.project.model.business.User;

/**
 * @author user
 *
 */
public interface IUserReader {
	
	/**
	 * @param id
	 * @return
	 * @throws UserException
	 */
	public User getOneUser(Long id) throws UserException;
	/**
	 * @return all the users
	 */
	public Set<User> getAllUsers();

}
