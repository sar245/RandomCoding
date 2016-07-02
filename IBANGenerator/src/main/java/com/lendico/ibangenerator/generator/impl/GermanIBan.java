package com.lendico.ibangenerator.generator.impl;

import java.util.concurrent.ThreadLocalRandom;

import com.lendico.ibangenerator.enums.Country;
import com.lendico.ibangenerator.generator.IBanGenerator;

public class GermanIBan extends IBanGenerator {
	
	private static final String COUNTRY_CODE = Country.GERMANY.value();
	
	private static final long COUNTRY_CODE_DIGIT_REPRESENTATION = 1314;
	
	private static final long BANK_CODE_LENGTH_MIN = 10000000;
	
	private static final long BANK_CODE_LENGTH_MAX = 100000000;

	private static final long ACCOUNT_NUMBER_LENGTH_MIN = 1000000000;
	
	private static final long ACCOUNT_NUMBER_LENGTH_MAX = 10000000000L;

	public String generateIBan() {
		return generateIBan(COUNTRY_CODE);
	}

	protected String generateBankCode() {
		return new StringBuffer().append(ThreadLocalRandom.current().nextLong(BANK_CODE_LENGTH_MIN, BANK_CODE_LENGTH_MAX)).toString();
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
