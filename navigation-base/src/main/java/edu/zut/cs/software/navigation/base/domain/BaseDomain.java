package edu.zut.cs.software.navigation.base.domain;

import java.io.Serializable;

/**
 * Base abstract class for Model objects. Child objects should implement
 * toString(), equals() and hashCode().
 *
 * @author 
 */
@SuppressWarnings("serial")
public abstract class BaseDomain implements Serializable {

	/**
	 * Compares object equality. When using Hibernate, the primary key should not be
	 * a part of this comparison.
	 *
	 * @param o
	 *            object to compare to
	 * @return true/false based on equality tests
	 */
	public abstract boolean equals(Object o);

	/**
	 * When you override equals, you should override hashCode. See "Why are equals()
	 * and hashCode() importation" for more information:
	 * http://www.hibernate.org/109.html
	 *
	 * @return hashCode
	 */
	public abstract int hashCode();

	/**
	 * Returns a multi-line String with key=value pairs.
	 *
	 * @return a String representation of this class.
	 */
	public abstract String toString();
}