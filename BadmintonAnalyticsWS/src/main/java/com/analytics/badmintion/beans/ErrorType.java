/**
 * 
 */
package com.analytics.badmintion.beans;

import java.io.Serializable;

/**
 * @author Arun Ramachandran
 *
 */
public enum ErrorType implements Serializable {
	OUT("Out"), NET("Net");

	private String value = null;

	private ErrorType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
