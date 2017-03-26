package com.cb.project.constants;

/**
 * @author user
 *
 */
public interface IAccountConstants {

	public interface Messages {
		/**
		 * RESSOURCE_NOT_EXISTS
		 */
		String RESSOURCE_NOT_EXISTS = "The account does not exist";
		
		
		/**
		 * RESSOURCE_NOT_EXISTS
		 */
		String ACCOUNT_USER_NOT_EXISTS = "The account does not have a correct involved user";
		
		/**
		 * MISSING_ATTRIBUTES
		 */
		String MISSING_ATTRIBUTES = "Missing attribute for the account";
		
		
		/**
		 * INSUFFICIENT_BALANCE
		 */
		String INSUFFICIENT_BALANCE = "Insufficient account balance";
		
		/**
		 * POSITIVE_NUMBER
		 */
		String POSITIVE_NUMBER = "Number must be positive";
		
	}
	/**
	 * @author user
	 *
	 */
	public interface Codes {
		
		/**
		 * MISSING_ATTRIBUTES
		 */
		String MISSING_ATTRIBUTES = "0101";
		
		
		/**
		 * MISSING_ATTRIBUTES
		 */
		String POSITIVE_NUMBER = "0102";
		
		/**
		 * RESSOURCE_NOT_EXISTS
		 */
		String RESSOURCE_NOT_EXISTS = "0201";

		
		/**
		 * ACCOUNT_USER_NOT_EXISTS
		 */
		String ACCOUNT_USER_NOT_EXISTS = "0202";
		
		
		/**
		 * INSUFFICIENT_BALANCE
		 */
		String INSUFFICIENT_BALANCE = "0203";
	}
	
	
}
