package com.cb.project.services.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cb.project.equivalence.AccountEquivalence;
import com.cb.project.exceptions.AccountException;
import com.cb.project.exceptions.UserException;
import com.cb.project.model.business.Account;
import com.cb.project.model.business.User;
import com.cb.project.model.data.DataStore;
import com.cb.project.services.IAccountReader;
import com.cb.project.services.impl.AccountReaderImpl;

/**
 * @author user
 *
 */
public class AccountReaderTest {
	
	/**
	 * service to test
	 */
	IAccountReader service = new AccountReaderImpl();

	 /**
	 * populate the datastore - kind of mock
	 */
	@BeforeClass
	 public static void populateData() {
		 User user = new User();
		 user.setAddress("rue de la paix");
		 user.setFirstName("prenom");
		 user.setLastName("nom");
		 user.setPhone("0836656565");
		 user.setId(1l);	
		Account account = new Account();
		account.setId(1234l);
		account.setCreation(LocalDate.now());
		account.setOwner(user);
		DataStore.getUsers().add(user);
		DataStore.getAccounts().add(account);
		 User user2 = new User();
		 user2.setAddress("rue de la paix");
		 user2.setFirstName("prenom2");
		 user2.setLastName("nom2");
		 user2.setPhone("0607080910");
		 user2.setId(1l);	
		Account account2 = new Account();
		account2.setId(2l);
		account2.setCreation(LocalDate.now());
		account2.setBalance(1235.0);
		account2.setOwner(user2);
		DataStore.getUsers().add(user2);
		DataStore.getAccounts().add(account2);
		Account account3 = new Account();
		account3.setId(1236l);
		account3.setCreation(LocalDate.now());
		account3.setBalance(1000.0);
		account3.setOwner(user2);
		DataStore.getAccounts().add(account3);
		
		
		
	 }
	 /**
	 * cleanData
	 */
	@AfterClass
	 public static void cleanData() {
		DataStore.getUsers().clear();
		DataStore.getAccounts().clear();
		DataStore.usertNumber = 0;
		DataStore.accountNumber = 0;
	 }
	
	
	/**
	 * testGetAllUsers
	 */
	@Test
	public void testGetAllAccounts() {
		 User user = new User();
		 user.setAddress("rue de la paix");
		 user.setFirstName("prenom");
		 user.setLastName("nom");
		 user.setPhone("0836656565");
		 user.setId(1l);	
		Account account = new Account();
		account.setId(1234l);
		account.setCreation(LocalDate.now());
		account.setOwner(user);
		 User user2 = new User();
		 user2.setAddress("rue de la paix");
		 user2.setFirstName("prenom2");
		 user2.setLastName("nom2");
		 user2.setPhone("0607080910");
		 user2.setId(1l);	
		Account account2 = new Account();
		account2.setId(2l);
		account2.setCreation(LocalDate.now());
		account2.setBalance(1235.0);
		account2.setOwner(user2);
		Account account3 = new Account();
		account3.setId(1236l);
		account3.setCreation(LocalDate.now());
		account3.setBalance(1000.0);
		account3.setOwner(user2);
		Set<AccountEquivalence> testData = new HashSet<>();
		testData.add(new AccountEquivalence(account3));
		testData.add(new AccountEquivalence(account2));
		testData.add(new AccountEquivalence(account));
		Set<Account> accounts = service.getAllAccounts();
		Set<AccountEquivalence> testValues = new HashSet<>();
		accounts.forEach(a -> {testValues.add(new AccountEquivalence(a));});
		Assert.assertEquals(testData, testValues);
		
	}
	
	/**
	 * testGetOneAccount
	 * @throws AccountException 
	 */
	@Test
	public void testGetOneAccount() throws UserException, AccountException {
		 User user = new User();
		 user.setAddress("rue de la paix");
		 user.setFirstName("prenom");
		 user.setLastName("nom");
		 user.setPhone("0836656565");
		 user.setId(1l);	
		Account account = new Account();
		account.setId(1234l);
		account.setCreation(LocalDate.now());
		account.setOwner(user);
		Account testValue = service.getOneAccount(1234l);
		AccountEquivalence eq = new AccountEquivalence(testValue);
		AccountEquivalence eq2 = new AccountEquivalence(account);
		Assert.assertEquals(eq2, eq);
	}

}
