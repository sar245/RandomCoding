/**
 * 
 */
package com.analytics.badmintion.beans;

import java.io.Serializable;

/**
 * @author Arun Ramachandran
 *
 */
public enum WinType implements Serializable {
	FORCED_ERROR("Forced Error"), UNFORCED_ERROR("Unforced Error"), WINNER ("Winner");

	private String value = null;

	private WinType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
