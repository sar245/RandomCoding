package com.lendico.ibangenerator.generator.impl;

import org.junit.Test;

import com.lendico.ibangenerator.enums.Country;
import com.lendico.ibangenerator.service.GenerateIBan;
import com.lendico.ibangenerator.utils.IBanVO;
import com.lendico.ibangenerator.utils.IBanValidator;

public class GermanIBanTestCase {

	@Test
	public void testGenerateIBan() {
		GenerateIBan g = new GenerateIBan();
		IBanVO ibanVO = new IBanVO(g.generateIBan(Country.GERMANY), Country.GERMANY);
		IBanValidator.valiateIban(ibanVO);
	}

}
