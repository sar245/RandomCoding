package com.lendico.ibangenerator.utils;

import java.util.List;
import java.util.Random;

import com.lendico.ibangenerator.enums.Country;
import com.lendico.ibangenerator.service.GenerateIBan;

public class GenerateIBanThread implements Runnable {

	private List<IBanVO> list;

	public GenerateIBanThread(List<IBanVO> list) {
		this.list = list;
	}

	public void run() {
		try {
		GenerateIBan generateIBan = new GenerateIBan();
		Country country = Country.values()[new Random().nextInt(Country
				.values().length)];
		String iban = generateIBan.generateIBan(country);
		list.add(new IBanVO(iban, country));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
