/**
 * 
 */
package com.bt.hyperledger.bulk.upload.commands;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import com.bt.hyperledger.bulk.upload.beans.BBCPEAsset;

/**
 * @author asubramanian
 *
 */
public class BulkUploadToHyperledgerCommand {

	@Autowired
	private UploadBBCPEToHyperledgerCommand uploadBBCPEToHyperledgerCommand;

	/**
	 * @return the uploadBBCPEToHyperledgerCommand
	 */
	public UploadBBCPEToHyperledgerCommand getUploadBBCPEToHyperledgerCommand() {
		return uploadBBCPEToHyperledgerCommand;
	}

	/**
	 * @param uploadBBCPEToHyperledgerCommand
	 *            the uploadBBCPEToHyperledgerCommand to set
	 */
	public void setUploadBBCPEToHyperledgerCommand(
			UploadBBCPEToHyperledgerCommand uploadBBCPEToHyperledgerCommand) {
		this.uploadBBCPEToHyperledgerCommand = uploadBBCPEToHyperledgerCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bt.hyperledger.bulk.upload.commands.IHyperledgerBulkUploadCommand
	 * #execute(java.lang.Object)
	 */
	@Async("bulkUploadToHyperledgerCommandExecutor")
	public void execute(Object vo) {
		Date d1 = new Date();
		Map<Integer, List<BBCPEAsset>> map = (Map<Integer, List<BBCPEAsset>>) vo;
		List<BBCPEAsset> list = null;
		int batchId = 0;
		for (Integer batchID : map.keySet()) {
			batchId = batchID;
			list = map.get(batchID);
		}
		for (BBCPEAsset bbcpeAsset : list) {
			uploadBBCPEToHyperledgerCommand.execute(bbcpeAsset);
		}
		Date d2 = new Date();
		System.out.println("Time spent excuting bulk of batch id " + batchId
				+ " is : " + (d2.getTime() - d1.getTime()) + " of size : "
				+ list.size());
	}

}
