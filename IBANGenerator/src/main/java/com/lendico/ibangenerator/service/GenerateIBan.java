package com.lendico.ibangenerator.service;

import java.util.Random;

import com.lendico.ibangenerator.enums.Country;
import com.lendico.ibangenerator.factory.IBanGeneratorFactory;

public class GenerateIBan {
	IBanGeneratorFactory factory = new IBanGeneratorFactory();

	public String generateIBanRandomly() {
		return generateIBan(Country.values()[new Random().nextInt(Country.values().length)]);
	}

	public String generateIBan(Country country) {
		return factory.getGenerator(country).generateIBan();
	}
}
