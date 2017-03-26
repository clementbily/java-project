package com.cb.project.services.test;

import java.time.LocalDate;
import java.time.Month;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cb.project.exceptions.AccountException;
import com.cb.project.exceptions.AppException;
import com.cb.project.model.business.Account;
import com.cb.project.model.business.User;
import com.cb.project.model.data.DataStore;
import com.cb.project.services.IAccountCrud;
import com.cb.project.services.impl.AccountCrudImpl;

/**
 * @author user
 *
 */
public class AccountCrudTest {

	 /**
	 * service to test
	 */
	private IAccountCrud service = new AccountCrudImpl();
	 
	 /**
	 * populateData
	 */
	@Before
	 public  void populateData() {
		 User user = new User();
		 user.setAddress("rue de la paix");
		 user.setFirstName("prenom");
		 user.setLastName("nom");
		 user.setPhone("0836656565");
		 user.setId(1l);	
		Account account = new Account();
		account.setId(1234l);
		account.setBalance(1000.0);
		account.setCreation(LocalDate.now());
		account.setOwner(user);
		DataStore.getUsers().add(user);
		DataStore.usertNumber++;
		DataStore.getAccounts().add(account);
		DataStore.accountNumber++;
	 }
	 /**
	 * cleanData
	 */
	@After
	 public void cleanData() {
		DataStore.getUsers().clear();
		DataStore.getAccounts().clear();
		DataStore.usertNumber = 0;
		DataStore.accountNumber = 0;
	 }
	
	/**
	 * @throws AccountException
	 * @throws AppException
	 */
	@Test
	public void testCreate() throws AccountException, AppException {
		User user = new User();
		user.setId(1l);//test case user
		Account account = new Account();
		account.setCreation(LocalDate.now());
		account.setOwner(user);
		service.create(account);
		
		Assert.assertTrue(DataStore.getAccounts().contains(account));
		
	}
	
	
	/**
	 * @throws AccountException
	 * @throws AppException
	 */
	@Test(expected = AccountException.class)
	public void testCreatevalidationError() throws AccountException, AppException {
		Account account = new Account();
		account.setId(1234l);
		service.create(account);
	}
	
	
	/**
	 * @throws AccountException
	 * @throws AppException
	 */
	@Test
	public void testUpdate() throws AccountException, AppException {
		User user = new User();
		user.setId(1l);//test case user
		Account account = new Account();
		account.setId(1234l);
		LocalDate newDate = LocalDate.of(2012, Month.DECEMBER, 12);
		account.setCreation(newDate);
		account.setOwner(user);
		service.update(account);
		Assert.assertTrue(DataStore.getAccounts().stream().filter( a -> a.getCreation().equals(newDate)).findFirst().isPresent());
	}
	
	
	/**
	 * @throws AccountException
	 * @throws AppException
	 */
	@Test(expected = AccountException.class)
	public void testUpdateValidationError() throws AccountException, AppException {
		Account account = new Account();
		service.update(account);
	}
	
	
	
	/**
	 * @throws AccountException
	 */
	@Test
	public void testDelete() throws AccountException {
		Account account = new Account();
		account.setId(1234l);
		service.delete(account);
		Assert.assertTrue(!DataStore.getAccounts().contains(account));
	}
	
	
	/**
	 * @throws AccountException
	 * @throws AppException
	 */
	@Test(expected = AccountException.class)
	public void testDeleteInexisting() throws AccountException, AppException {
		Account account = new Account();
		service.update(account);
	}
	
	/**
	 * @throws AccountException
	 */
	@Test
	public void testCashWithdrawal() throws AccountException {
		Account account = new Account();
		account.setId(1234l);
		service.withdraw(account, 100);
		Assert.assertTrue(DataStore.getAccounts().stream().filter(a -> a.getId().equals(account.getId())).findFirst().get().getBalance() == 900.0 );
	}
	
	
	/**
	 * @throws AccountException
	 */
	@Test(expected = AccountException.class)
	public void testCashWithdrawalIncorrectBalance() throws AccountException {
		Account account = new Account();
		account.setId(1234l);
		service.withdraw(account, 1500);// failed because the current balance is 1000
	}
	
	/**
	 * @throws AccountException
	 */
	@Test(expected = AccountException.class)
	public void testCashWithdrawalNegativeNumber() throws AccountException {
		Account account = new Account();
		account.setId(1234l);
		service.withdraw(account, -500);// failed because the current balance is 1000
	}
	
	
	
	/**
	 * @throws AccountException
	 */
	@Test
	public void testDeposite() throws AccountException {
		Account account = new Account();
		account.setId(1234l);
		service.deposit(account, 100);
		Assert.assertTrue(DataStore.getAccounts().stream().filter(a -> a.getId().equals(account.getId())).findFirst().get().getBalance() == 1100);
	}
	
	
	/**
	 * @throws AccountException
	 */
	@Test(expected = AccountException.class)
	public void testDepositNegativeNumber() throws AccountException {
		Account account = new Account();
		account.setId(1234l);
		service.deposit(account, -1500);// failed because the current balance is 1000
	}
	

}
