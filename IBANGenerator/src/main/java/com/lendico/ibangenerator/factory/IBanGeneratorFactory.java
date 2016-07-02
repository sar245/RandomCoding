package com.lendico.ibangenerator.factory;

import com.lendico.ibangenerator.enums.Country;
import com.lendico.ibangenerator.generator.IBanGenerator;
import com.lendico.ibangenerator.generator.impl.AustrianIBan;
import com.lendico.ibangenerator.generator.impl.DutchIBan;
import com.lendico.ibangenerator.generator.impl.GermanIBan;

public class IBanGeneratorFactory {

	public IBanGenerator getGenerator(Country country) {
		switch (country) {
		case GERMANY:
			return new GermanIBan();
		case AUSTRIA:
			return new AustrianIBan();
		case NETHERLANDS:
			return new DutchIBan();
		default:
			return null;
		}
	}
}
