package com.lendico.ibangenerator.utils;

import com.lendico.ibangenerator.enums.Country;

public class IBanVO {
	private String iban;
	private Country country;

	public IBanVO(String iban, Country country) {
		super();
		this.iban = iban;
		this.country = country;
	}

	/**
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @param iban
	 *            the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IBanVO [iban=" + iban + ", country=" + country + "]";
	}
}
