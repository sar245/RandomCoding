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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Arun Ramachandran
 *
 */
@Entity
@Table(name = "Game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gameId")
	private int gameId;

	@Column(name = "gameNumber")
	private int gameNumber;

	@Column(name = "result")
	private int result;

	@Column(name = "notes")
	private String notes;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "matchId", referencedColumnName = "matchId")
	private Match match;

	@OneToMany(mappedBy = "gameId", cascade = CascadeType.ALL)
	private List<Point> points;

	/**
	 * @return the gameId
	 */
	public int getGameId() {
		return gameId;
	}

	/**
	 * @param gameId
	 *            the gameId to set
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	/**
	 * @return the gameNumber
	 */
	public int getGameNumber() {
		return gameNumber;
	}

	/**
	 * @param gameNumber
	 *            the gameNumber to set
	 */
	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(int result) {
		this.result = result;
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
	 * @return the match
	 */
	public Match getMatch() {
		return match;
	}

	/**
	 * @param match
	 *            the match to set
	 */
	public void setMatch(Match match) {
		this.match = match;
	}

	/**
	 * @return the points
	 */
	public List<Point> getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(List<Point> points) {
		this.points = points;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameNumber=" + gameNumber + ", result=" + result + ", notes=" + notes
				+ ", match=" + match + ", points=" + points + "]";
	}

}
