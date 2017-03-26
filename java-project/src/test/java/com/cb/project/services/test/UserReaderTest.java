package com.cb.project.services.test;

import java.util.Set;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cb.project.equivalence.UserEquivalence;
import com.cb.project.exceptions.AccountException;
import com.cb.project.exceptions.UserException;
import com.cb.project.model.business.User;
import com.cb.project.model.data.DataStore;
import com.cb.project.services.IUserReader;
import com.cb.project.services.impl.UserReaderImpl;

/**
 * @author user
 *
 */
public class UserReaderTest {
	
	 /**
	 * service
	 */
	private IUserReader service = new UserReaderImpl();

	 /**
	 * populateData
	 */
	@BeforeClass
	 public static void populateData() {
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
	 * cleanData
	 */
	@AfterClass
	 public static void cleanData() {
		DataStore.getUsers().clear();
		DataStore.getAccounts().clear();
		DataStore.usertNumber = 0;
	 }
	
	/**
	 * testGetAllUsers
	 */
	@Test
	public void testGetAllUsers() {
		 User user = new User();
		 user.setAddress("rue de la paix");
		 user.setFirstName("prenom");
		 user.setLastName("nom");
		 user.setPhone("0836656565");
		 user.setId(1l);
		 Set<User> users = service.getAllUsers();
		 
		 Assert.assertTrue(users.size() ==1 && new UserEquivalence(users.iterator().next()).equals(new UserEquivalence(user)));
		 
	}
	
	/**
	 * testGetOneAccount
	 * @throws AccountException 
	 */
	@Test
	public void testGetOneUser() throws UserException {
		 User user = new User();
		 user.setAddress("rue de la paix");
		 user.setFirstName("prenom");
		 user.setLastName("nom");
		 user.setPhone("0836656565");
		 user.setId(1l);	
		User testValue = service.getOneUser(1l);
		UserEquivalence eq = new UserEquivalence(testValue);
		UserEquivalence eq2 = new UserEquivalence(user);
		Assert.assertEquals(eq, eq2);
	}

}
