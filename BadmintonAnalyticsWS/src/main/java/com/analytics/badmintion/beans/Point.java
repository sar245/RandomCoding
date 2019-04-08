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
@Table(name = "Point")
public class Point {

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "pointId")
	private int pointId;

	@Column(name = "servedBy")
	private int servedBy;

	@Column(name = "result")
	private int result;

	@Column(name = "notes")
	private String notes;

	@Column(name = "gameId")
	private int gameId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gameId", referencedColumnName = "gameId")
	private Game game;

	@OneToMany(mappedBy = "point", cascade = CascadeType.ALL)
	private List<Stroke> strokes;

	/**
	 * @return the pointId
	 */
	public int getPointId() {
		return pointId;
	}

	/**
	 * @param pointId
	 *            the pointId to set
	 */
	public void setPointId(int pointId) {
		this.pointId = pointId;
	}

	/**
	 * @return the servedBy
	 */
	public int getServedBy() {
		return servedBy;
	}

	/**
	 * @param servedBy
	 *            the servedBy to set
	 */
	public void setServedBy(int servedBy) {
		this.servedBy = servedBy;
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
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game
	 *            the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return the strokes
	 */
	public List<Stroke> getStrokes() {
		return strokes;
	}

	/**
	 * @param strokes the strokes to set
	 */
	public void setStrokes(List<Stroke> strokes) {
		this.strokes = strokes;
	}

}
