package com.cb.project.equivalence;

import com.cb.project.model.business.Account;

/**
 * @author user
 * provides custom account equals
 */
public class AccountEquivalence {
	
	/**
	 * @param account
	 */
	public AccountEquivalence(Account account) {
		super();
		this.account = account;
	}

	/**
	 * account
	 */
	private Account account;

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountEquivalence other = (AccountEquivalence) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		}
		else if (account != null) {
			if (other.account == null)
				return false;
		}
			if (Double.doubleToLongBits(account.getBalance()) != Double.doubleToLongBits(other.account.getBalance()))
				return false;
			if (account.getCreation() == null) {
				if (other.account.getCreation() != null)
					return false;
			} else if (!account.getCreation().equals(other.account.getCreation()))
				return false;
			if (account.getId() == null) {
				if (other.account.getId() != null)
					return false;
			} else if (!account.getId().equals(other.account.getId()))
				return false;
			if (account.getOwner() == null) {
				if (other.account.getOwner() != null)
					return false;
			} else if (!new UserEquivalence(account.getOwner()).equals(new UserEquivalence(other.account.getOwner())))
				return false;
			
		return true;
	}
	
	
}
