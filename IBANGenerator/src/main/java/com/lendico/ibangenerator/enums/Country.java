package com.lendico.ibangenerator.enums;

public enum Country {
	GERMANY("DE"), AUSTRIA("AT"), NETHERLANDS("NL");

	private final String value;

	Country(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static Country fromValue(String v) {
		for (Country c : Country.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
