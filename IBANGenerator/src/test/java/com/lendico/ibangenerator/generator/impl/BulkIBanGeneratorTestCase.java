package com.lendico.ibangenerator.generator.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;

import com.lendico.ibangenerator.utils.GenerateIBanThread;
import com.lendico.ibangenerator.utils.IBanVO;
import com.lendico.ibangenerator.utils.IBanValidator;

public class BulkIBanGeneratorTestCase {

	@Test
	public void test() {
		long t = System.currentTimeMillis();
		int threadCount = 1000000;
		List<IBanVO> list = new ArrayList<IBanVO>(threadCount);
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		for (int i = 0; i < threadCount; i++) {
			GenerateIBanThread ibanThread = new GenerateIBanThread(list);
			executor.execute(ibanThread);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		t = System.currentTimeMillis() - t;
		System.out.println("Running time for "+ threadCount + " is " + t + " milliseconds");
		int nullCount = 0;
		for (IBanVO iBanVO : list) {
			if (iBanVO != null) {
				IBanValidator.valiateIban(iBanVO);
			} else {
				nullCount++;
			}
		}
		System.out.println("nullCount : " + nullCount);
	}

}
