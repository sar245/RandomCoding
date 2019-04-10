/**
 * 
 */
package com.analytics.badmintion.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Arun Ramachandran
 *
 */
@Entity
@Table(name = "Tournament")
public class Tournament {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "tournamentId")
	private int tournamentId;

	@Column(name = "name")
	private String name;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;

	@OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
	private List<Match> matches;

	/**
	 * @return the tournamentId
	 */
	public int getTournamentId() {
		return tournamentId;
	}

	/**
	 * @param tournamentId
	 *            the tournamentId to set
	 */
	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
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
	 * @return the matches
	 */
	public List<Match> getMatches() {
		return matches;
	}

	/**
	 * @param matches
	 *            the matches to set
	 */
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tournament [tournamentId=" + tournamentId + ", name=" + name + ", city=" + city + ", country=" + country
				+ ", matches=" + matches + "]";
	}

}
