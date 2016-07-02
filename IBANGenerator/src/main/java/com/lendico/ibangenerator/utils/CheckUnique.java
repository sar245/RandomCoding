package com.lendico.ibangenerator.utils;

import java.util.HashMap;
import java.util.Map;

public class CheckUnique {

	private static Map<String, String> map = new HashMap<String, String>();
	
	/*
	 * A private Constructor prevents any other class from instantiating.
	 */
	private CheckUnique() {
	}

	public static boolean checkUniquenessAndSave(String iban) {
		if (map.containsKey(iban)) {
			System.out.println("Key was found");
			return false;
		} else {
			map.put(iban, iban);
			return true;
		}
	}
	
}
