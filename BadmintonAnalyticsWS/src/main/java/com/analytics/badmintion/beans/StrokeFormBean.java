/**
 * 
 */
package com.analytics.badmintion.beans;

import java.io.Serializable;

/**
 * @author Arun Ramachandran
 *
 */
public class StrokeFormBean implements Serializable {

	private String from;
	private String to;
	private String condition;

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StrokeFormBean [from=" + from + ", to=" + to + ", condition=" + condition + "]";
	}

}
