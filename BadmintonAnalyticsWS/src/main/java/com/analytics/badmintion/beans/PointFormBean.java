/**
 * 
 */
package com.analytics.badmintion.beans;

import java.io.Serializable;
import java.util.List;

/**
 * @author Arun Ramachandran
 *
 */
public class PointFormBean implements Serializable {
	private String gameId;
	private int servedBy;
	private List<StrokeFormBean> strokes;
	private WinType winType;
	private ErrorType errorType;
	private int wonBy;

	/**
	 * @return the gameId
	 */
	public String getGameId() {
		return gameId;
	}

	/**
	 * @param gameId
	 *            the gameId to set
	 */
	public void setGameId(String gameId) {
		this.gameId = gameId;
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
	 * @return the strokes
	 */
	public List<StrokeFormBean> getStrokes() {
		return strokes;
	}

	/**
	 * @param strokes
	 *            the strokes to set
	 */
	public void setStrokes(List<StrokeFormBean> strokes) {
		this.strokes = strokes;
	}

	/**
	 * @return the winType
	 */
	public WinType getWinType() {
		return winType;
	}

	/**
	 * @param winType
	 *            the winType to set
	 */
	public void setWinType(WinType winType) {
		this.winType = winType;
	}

	/**
	 * @return the errorType
	 */
	public ErrorType getErrorType() {
		return errorType;
	}

	/**
	 * @param errorType
	 *            the errorType to set
	 */
	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}

	/**
	 * @return the wonBy
	 */
	public int getWonBy() {
		return wonBy;
	}

	/**
	 * @param wonBy
	 *            the wonBy to set
	 */
	public void setWonBy(int wonBy) {
		this.wonBy = wonBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PointFormBean [gameId=" + gameId + ", servedBy=" + servedBy + ", strokes=" + strokes + ", winType="
				+ winType + ", errorType=" + errorType + ", wonBy=" + wonBy + "]";
	}

}
