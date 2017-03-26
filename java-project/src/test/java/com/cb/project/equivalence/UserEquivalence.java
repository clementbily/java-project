package com.cb.project.equivalence;

import com.cb.project.model.business.User;

/**
 * @author user
 * provides custom user equals
 */
public class UserEquivalence {
	
	/**
	 * service
	 */
	private User user;

	/**
	 * @param user
	 */
	public UserEquivalence(User user) {
		this.user = user;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserEquivalence other = (UserEquivalence) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		}
		else if (user != null) {
			if (other.user == null)
				return false;
		}
		
		User otherUser = (User) other.user;
		if (user.getAddress() == null) {
			if (otherUser.getAddress() != null)
				return false;
		} else if (!user.getAddress().equals(otherUser.getAddress()))
			return false;
		if (user.getFirstName() == null) {
			if (otherUser.getFirstName() != null)
				return false;
		} else if (!user.getFirstName().equals(otherUser.getFirstName()))
			return false;
		if (user.getId() == null) {
			if (otherUser.getId() != null)
				return false;
		} else if (!user.getId().equals(otherUser.getId()))
			return false;
		if (user.getLastName() == null) {
			if (otherUser.getLastName() != null)
				return false;
		} else if (!user.getLastName().equals(otherUser.getLastName()))
			return false;
		if (user.getPhone() == null) {
			if (otherUser.getPhone() != null)
				return false;
		} else if (!user.getPhone().equals(otherUser.getPhone()))
			return false;
		return true;
	}
}
