/**
 * 
 */
package com.cb.project.validator;

import com.cb.project.exceptions.AppException;

/**
 * @author user
 *
 */
public interface Validator<E> {

	/**
	 * @param element
	 * @throws AppException
	 */
	public void validate(E element) throws AppException;
}
