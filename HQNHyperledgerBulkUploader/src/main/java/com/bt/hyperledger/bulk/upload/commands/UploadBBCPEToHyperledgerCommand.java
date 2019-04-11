/**
 * 
 */
package com.bt.hyperledger.bulk.upload.commands;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bt.hyperledger.bulk.upload.beans.BBCPEAsset;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author asubramanian
 *
 */
public class UploadBBCPEToHyperledgerCommand {

	@Value("${rest.bbcpe.upload.url}")
	private String postBbcpeUrl;

	@Autowired
	private final RestTemplate restTemplate;

	/**
	 * @return the postBbcpeUrl
	 */
	public String getPostBbcpeUrl() {
		return postBbcpeUrl;
	}

	/**
	 * @param postBbcpeUrl
	 *            the postBbcpeUrl to set
	 */
	public void setPostBbcpeUrl(String postBbcpeUrl) {
		this.postBbcpeUrl = postBbcpeUrl;
	}

	public UploadBBCPEToHyperledgerCommand(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bt.hyperledger.bulk.upload.commands.IHyperledgerBulkUploadCommand
	 * #execute(java.lang.Object)
	 */
	@Async("uploadBBCPEToHyperledgerCommandExecutor")
	public void execute(Object vo) {
		BBCPEAsset bbcpeAsset = (BBCPEAsset) vo;
		try { 
			Date d1 = new Date();
			BBCPEAsset response = restTemplate.postForObject(postBbcpeUrl,
					bbcpeAsset, BBCPEAsset.class);
			Date d2 = new Date();
			//System.out.println("Time customer : " + bbcpeAsset.getCustomerId() + " spent : " + (d2.getTime()-d1.getTime()));
		} catch (RestClientException e) {
			System.out.println("Message >> " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Message >> " + e.getMessage());
			e.printStackTrace();
		}

	}

}
