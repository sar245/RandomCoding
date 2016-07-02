package com.lendico.ibangenerator.utils;

public class ApplicationUtils {
	public static int convertIBanStringIbanInteger(char c) {
		return ((int) c - 55);
	}
}
