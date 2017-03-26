package com.cb.project.services.test;

import org.junit.After;
import  org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.cb.project.exceptions.AppException;
import com.cb.project.exceptions.UserException;
import com.cb.project.model.business.User;
import com.cb.project.model.data.DataStore;
import com.cb.project.services.IUserCrud;
import com.cb.project.services.impl.UserCrudImpl;



/**
 * @author user
 *
 */
public class UserCrudTest {

	 private IUserCrud service = new UserCrudImpl();
	 
	 
	 /**
	 * populate the set of users // kind of mock
	 */
	@Before
	 public  void populateData() {
		 User user = new User();
		 user.setAddress("rue de la paix");
		 user.setFirstName("prenom");
		 user.setLastName("nom");
		 user.setPhone("0836656565");
		 user.setId(1l);	
		DataStore.getUsers().add(user);
		DataStore.usertNumber++;
	 }
	 /**
	 * clean the set of users
	 */
	@After
	 public void cleanData() {
		DataStore.getUsers().clear();
		DataStore.getAccounts().clear();
		DataStore.usertNumber = 0;
	 }

	/**
	 * @throws UserException
	 * @throws AppException
	 */
	@Test
	public void testCreate() throws UserException, AppException {
		User user = new User();
		user.setAddress("27 rue du generale de gaulle");
		user.setFirstName("clement");
		user.setLastName("BILY");
		user.setPhone("0101010101");
		service.create(user);
		Assert.assertTrue(DataStore.getUsers().contains(user));
	}

	/**
	 * @throws UserException
	 * @throws AppException
	 */
	@Test(expected = UserException.class)
	public void testCreatevalidationError() throws UserException, AppException {
		User user = new User();
		user.setId(1234l);
		service.create(user);
	}

	/**
	 * @throws UserException
	 * @throws AppException
	 */
	@Test
	public void testUpdate() throws UserException, AppException {
		 User user = new User();
		 user.setFirstName("newPrenom");
		 user.setPhone("0101010101");
		 user.setId(1l);
		 service.update(user);
		 User updatedUser = DataStore.getUsers().stream().filter(u -> u.equals(user)).findFirst().get();
		 Assert.assertArrayEquals(new String[]{"newPrenom","0101010101"},new String[]{updatedUser.getFirstName(), updatedUser.getPhone()} );
	}
	
	/**
	 * @throws UserException
	 * @throws AppException
	 */
	@Test(expected = UserException.class)
	public void testUpdateValidationError() throws UserException, AppException {
		User user = new User();
		service.update(user);
	}	
			
	/**
	 * @throws UserException
	 */
	@Test
	public void testDelete() throws UserException {
		User user = new User();
		user.setId(1l);
		service.delete(user);
		Assert.assertTrue(!DataStore.getUsers().contains(user));
	}

	/**
	 * @throws UserException
	 * @throws AppException
	 */
	@Test(expected = UserException.class)
	public void testDeleteInexisting() throws UserException, AppException {
		User user = new User();
		service.delete(user);
	}
}
