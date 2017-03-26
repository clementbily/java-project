package com.cb.project.services;

import com.cb.project.exceptions.AppException;
import com.cb.project.exceptions.UserException;
import com.cb.project.model.business.User;

public interface IUserCrud {
	
	public Long create(User user) throws UserException, AppException;
	public void update (User user) throws UserException, AppException;
	public void delete(User user) throws UserException;

}
