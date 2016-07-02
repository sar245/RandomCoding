package com.lendico.ibangenerator.generator;

import java.math.BigInteger;

import com.lendico.ibangenerator.utils.ApplicationUtils;
import com.lendico.ibangenerator.utils.CheckUnique;

public abstract class IBanGenerator {

	public static final String CHECKSUM_PLACE_HOLDER = "00";

	public static final BigInteger BIGINTEGER_97 = new BigInteger("97");
	
	public static final BigInteger BIGINTEGER_98 = new BigInteger("98");
	
	public static final int BANK_CODE_ALPABHET_A = 65;
	
	public static final int BANK_CODE_ALPHABET_Z = 91;
	
	public abstract String generateIBan();

	protected String generateIBan(String countryCode) {
		boolean isUnique = false;
		while (!isUnique) {
			String bankCode = generateBankCode();
			long accountNumber = generateAccountNumber();
			String checkSumCalculator = generateCheckSumCalculatorString(
					bankCode, accountNumber);
			String checksum = checkSumDigitCalculator(checkSumCalculator);
			String iban = generateIban(checksum, bankCode, accountNumber);
			isUnique = CheckUnique.checkUniquenessAndSave(iban);
			if (isUnique)
				return iban;
		}
		return null;
	}

	protected abstract String generateBankCode();

	protected abstract long generateAccountNumber();

	protected abstract String generateCheckSumCalculatorString(String bankCode,
			long accountNumber);

	protected abstract String generateIban(String checkSum, String bankCode,
			long accountNumber);

	private String checkSumDigitCalculator(String checkSumCalculator) {
		StringBuffer convertedIban = new StringBuffer(checkSumCalculator);
		for (int i = 0; i < convertedIban.length(); i++) {
			char c = convertedIban.charAt(i);
			if (Character.isLetter(c)) {
				convertedIban.replace(i, i+1, Integer.toString(ApplicationUtils.convertIBanStringIbanInteger(c)));
				i++;
			}
		}
		BigInteger ibanBI = new BigInteger(convertedIban.toString());
		BigInteger mod = ibanBI.mod(BIGINTEGER_97);
		BigInteger reminder = BIGINTEGER_98.subtract(mod);
		StringBuffer checkSum = new StringBuffer(reminder.toString());
		return (checkSum.length() == 2) ? checkSum.toString() : checkSum.insert(0, 0).toString();
	}
}
