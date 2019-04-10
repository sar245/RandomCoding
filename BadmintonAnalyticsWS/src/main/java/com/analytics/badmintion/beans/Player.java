package com.analytics.badmintion.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Player")
public class Player implements Serializable {
	
	private static final long serialVersionUID = 2185574601230207424L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "playerId")
	private int playerId;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "middleName")
	private String middleName;
	@Column(name = "country")
	private String country;
	@Column(name = "gender")
	private String gender;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	@Column(name = "placeOfBirth")
	private String placeOfBirth;
	@Column(name = "primaryHand")
	private String primaryHand;

//	public Player(String firstName, String lastName, String middleName, String country, String gender,
//			Date dateOfBirth, String placeOfBirth, String primaryHand) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.middleName = middleName;
//		this.country = country;
//		this.gender = gender;
//		this.dateOfBirth = dateOfBirth;
//		this.placeOfBirth = placeOfBirth;
//		this.primaryHand = primaryHand;
//	}

	/**
	 * 
	 */
	public Player() {
		super();
	}

	/**
	 * @return the playerId
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId
	 *            the playerId to set
	 */
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the placeOfBirth
	 */
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	/**
	 * @param placeOfBirth
	 *            the placeOfBirth to set
	 */
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	/**
	 * @return the primaryHand
	 */
	public String getPrimaryHand() {
		return primaryHand;
	}

	/**
	 * @param primaryHand
	 *            the primaryHand to set
	 */
	public void setPrimaryHand(String primaryHand) {
		this.primaryHand = primaryHand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", country=" + country + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", placeOfBirth=" + placeOfBirth + ", primaryHand=" + primaryHand + "]";
	}

}
