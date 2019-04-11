package com.bt.hyperledger.bulk.upload.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bt.hyperledger.bulk.upload.beans.Greeting;
import com.bt.hyperledger.bulk.upload.commands.GenerateBBCPEAssetsCommand;

@RestController
public class HyperledgeBulkUploadControllerController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GenerateBBCPEAssetsCommand generateBBCPEAssetsCommand;

	/**
	 * @return the generateBBCPEAssetsCommand
	 */
	public GenerateBBCPEAssetsCommand getGenerateBBCPEAssetsCommand() {
		return generateBBCPEAssetsCommand;
	}

	/**
	 * @param generateBBCPEAssetsCommand
	 *            the generateBBCPEAssetsCommand to set
	 */
	public void setGenerateBBCPEAssetsCommand(GenerateBBCPEAssetsCommand generateBBCPEAssetsCommand) {
		this.generateBBCPEAssetsCommand = generateBBCPEAssetsCommand;
	}

	@RequestMapping("/loadData")
	public Greeting greeting(@RequestParam(value = "recordCount", defaultValue = "100000") String recordCount) {

		generateBBCPEAssetsCommand.execute(Long.parseLong(recordCount));
		return new Greeting(counter.incrementAndGet(), String.format(template, recordCount));
	}
}
