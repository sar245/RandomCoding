/**
 * 
 */
package com.analytics.badmintion.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Arun Ramachandran
 *
 */
@Entity
@Table(name = "Stroke")
public class Stroke {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "strokeId")
	private int strokeId;

	@Column(name = "shotId")
	private int shotId;

	@Column(name = "handId")
	private int handId;

	@Column(name = "notes")
	private String notes;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pointId", referencedColumnName = "pointId")
	private Point point;

	/**
	 * @return the strokeId
	 */
	public int getStrokeId() {
		return strokeId;
	}

	/**
	 * @param strokeId
	 *            the strokeId to set
	 */
	public void setStrokeId(int strokeId) {
		this.strokeId = strokeId;
	}

	/**
	 * @return the shotId
	 */
	public int getShotId() {
		return shotId;
	}

	/**
	 * @param shotId
	 *            the shotId to set
	 */
	public void setShotId(int shotId) {
		this.shotId = shotId;
	}

	/**
	 * @return the handId
	 */
	public int getHandId() {
		return handId;
	}

	/**
	 * @param handId
	 *            the handId to set
	 */
	public void setHandId(int handId) {
		this.handId = handId;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * @param point
	 *            the point to set
	 */
	public void setPoint(Point point) {
		this.point = point;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stroke [strokeId=" + strokeId + ", shotId=" + shotId + ", handId=" + handId + ", notes=" + notes
				+ ", point=" + point + "]";
	}

}
