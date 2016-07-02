package com.lendico.ibangenerator.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;

import com.lendico.ibangenerator.enums.Country;
import com.lendico.ibangenerator.generator.IBanGenerator;

public class IBanValidator {

	public static void valiateIban(IBanVO iBanVO) {
		switch (iBanVO.getCountry()) {
		case GERMANY:
			testGerman(iBanVO.getIban());
			break;
		case AUSTRIA:
			testAustrian(iBanVO.getIban());
			break;
		case NETHERLANDS:
			testDutch(iBanVO.getIban());
			break;
		}

	}
	
	private static void testGerman(String iban) {
		assertEquals("Not of proper length", 22, iban.length());
		assertEquals("Country code does not match", Country.GERMANY.value(), iban.substring(0, 2));
		try {
			new BigInteger(iban.substring(2));
		} catch (NumberFormatException e) {
			fail("Invalid IBAN contains alpbabets");
		}
		assertTrue("Failed the mod 97 check", IBanValidator.validate(iban));
	}
	
	private static void testDutch(String iban) {
		assertEquals("Not of proper length",18, iban.length());
		assertEquals("Country code does not match", Country.NETHERLANDS.value(), iban.substring(0, 2));
		for (int i = 4; i < 8; i++) {
			assertTrue("Bank code is not string", Character.isLetter(iban.charAt(i)));
		}
		try {
			new BigInteger(iban.substring(8));
		} catch (NumberFormatException e) {
			fail("Invalid IBAN contains alpbabets");
		}
		assertTrue("Failed the mod 97 check", IBanValidator.validate(iban));
	}
	
	private static void testAustrian(String iban) {
		assertEquals("Not of proper length", 20, iban.length());
		assertEquals("Country code does not match", Country.AUSTRIA.value(), iban.substring(0, 2));
		try {
			new BigInteger(iban.substring(2));
		} catch (NumberFormatException e) {
			fail("Invalid IBAN contains alpbabets");
		}
		assertTrue("Failed the mod 97 check", IBanValidator.validate(iban));		
	}
	
	private static boolean validate(String iban) {
		StringBuffer rearrengedIban = new StringBuffer().append(iban.substring(4)).append(iban.substring(0,4));
		for (int i = 0; i < rearrengedIban.length(); i++) {
			char c = rearrengedIban.charAt(i);
			if (Character.isLetter(c)) {
				rearrengedIban.replace(i, i+1, Integer.toString(ApplicationUtils.convertIBanStringIbanInteger(c)));
				i++;
			}
		}
		BigInteger ibanBI = new BigInteger(rearrengedIban.toString());
		BigInteger mod = ibanBI.mod(IBanGenerator.BIGINTEGER_97);
		if (mod.equals(BigInteger.ONE)) return true;
		return false;
	}

}
