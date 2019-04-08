/**
 * 
 */
package com.analytics.badmintion.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "Match")
public class Match {

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "matchId")
	private int matchId;

	@Column(name = "description")
	private String description;

	@Column(name = "player1")
	private int player1;

	@Column(name = "player2")
	private int player2;

	@Column(name = "result")
	private int result;

	@Column(name = "notes")
	private String notes;

	@Column(name = "tournamentId")
	private int tournamentId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tournamentId", referencedColumnName = "tournamentId")
	private Tournament tournament;
	
	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
	private List<Game> games;

	/**
	 * @return the matchId
	 */
	public int getMatchId() {
		return matchId;
	}

	/**
	 * @param matchId
	 *            the matchId to set
	 */
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the player1
	 */
	public int getPlayer1() {
		return player1;
	}

	/**
	 * @param player1
	 *            the player1 to set
	 */
	public void setPlayer1(int player1) {
		this.player1 = player1;
	}

	/**
	 * @return the player2
	 */
	public int getPlayer2() {
		return player2;
	}

	/**
	 * @param player2
	 *            the player2 to set
	 */
	public void setPlayer2(int player2) {
		this.player2 = player2;
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
	 * @return the tournament
	 */
	public Tournament getTournament() {
		return tournament;
	}

	/**
	 * @param tournament
	 *            the tournament to set
	 */
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	/**
	 * @return the games
	 */
	public List<Game> getGames() {
		return games;
	}

	/**
	 * @param games the games to set
	 */
	public void setGames(List<Game> games) {
		this.games = games;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", description=" + description + ", player1=" + player1 + ", player2="
				+ player2 + ", result=" + result + ", notes=" + notes + ", tournamentId=" + tournamentId
				+ ", tournament=" + tournament + ", games=" + games + "]";
	}



}
