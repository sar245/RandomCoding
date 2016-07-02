package com.lendico.ibangenerator.generator.impl;

import java.util.concurrent.ThreadLocalRandom;

import com.lendico.ibangenerator.enums.Country;
import com.lendico.ibangenerator.generator.IBanGenerator;

public class DutchIBan extends IBanGenerator {

	private static final String COUNTRY_CODE = Country.NETHERLANDS.value();
	
	private static final long COUNTRY_CODE_DIGIT_REPRESENTATION = 2321;
	
	private static final int BANK_CODE_LENGTH = 4;

	private static final long ACCOUNT_NUMBER_LENGTH_MIN = 1000000000L;
	
	private static final long ACCOUNT_NUMBER_LENGTH_MAX = 10000000000L;
	
	public String generateIBan() {
		return generateIBan(COUNTRY_CODE);
	}

	protected String generateBankCode() {
		StringBuffer bankCode = new StringBuffer();
		for (int i = 0; i < BANK_CODE_LENGTH; i++) {
			bankCode.append((char)ThreadLocalRandom.current().nextInt(BANK_CODE_ALPABHET_A, BANK_CODE_ALPHABET_Z));
		}
		return bankCode.toString();
	}

	protected long generateAccountNumber() {
		return ThreadLocalRandom.current().nextLong(ACCOUNT_NUMBER_LENGTH_MIN, ACCOUNT_NUMBER_LENGTH_MAX);
	}

	protected String generateCheckSumCalculatorString(String bankCode, long accountNumber) {
		return new StringBuffer().append(bankCode).append(accountNumber).append(COUNTRY_CODE_DIGIT_REPRESENTATION).append(CHECKSUM_PLACE_HOLDER).toString();
	}

	protected String generateIban(String checkSum, String bankCode, long accountNumber) {
		return new StringBuffer(COUNTRY_CODE).append(checkSum).append(bankCode).append(accountNumber).toString();
	}

}
