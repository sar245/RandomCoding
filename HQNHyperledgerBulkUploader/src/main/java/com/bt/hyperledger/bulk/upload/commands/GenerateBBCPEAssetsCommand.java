/**
 * 
 */
package com.bt.hyperledger.bulk.upload.commands;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bt.hyperledger.bulk.upload.beans.BBCPE;
import com.bt.hyperledger.bulk.upload.beans.BBCPEAsset;
import com.bt.hyperledger.bulk.upload.beans.UniqueIDVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author asubramanian
 *
 */
public class GenerateBBCPEAssetsCommand {

	@Value("${batch.size}")
	private int batchSize;
	@Autowired
	private BulkUploadToHyperledgerCommand bulkUploadToHyperledgerCommand;

	@Autowired
	private UniqueIdGeneratorCommand uniqueIdGeneratorCommand;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bt.hyperledger.bulk.upload.commands.IHyperledgerBulkUploadCommand
	 * #execute(java.lang.Object)
	 */
	/**
	 * @return the batchSize
	 */
	public int getBatchSize() {
		return batchSize;
	}

	/**
	 * @param batchSize
	 *            the batchSize to set
	 */
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	/**
	 * @return the bulkUploadToHyperledgerCommand
	 */
	public BulkUploadToHyperledgerCommand getBulkUploadToHyperledgerCommand() {
		return bulkUploadToHyperledgerCommand;
	}

	/**
	 * @param bulkUploadToHyperledgerCommand
	 *            the bulkUploadToHyperledgerCommand to set
	 */
	public void setBulkUploadToHyperledgerCommand(
			BulkUploadToHyperledgerCommand bulkUploadToHyperledgerCommand) {
		this.bulkUploadToHyperledgerCommand = bulkUploadToHyperledgerCommand;
	}

	/**
	 * @return the uniqueIdGeneratorCommand
	 */
	public UniqueIdGeneratorCommand getUniqueIdGeneratorCommand() {
		return uniqueIdGeneratorCommand;
	}

	/**
	 * @param uniqueIdGeneratorCommand
	 *            the uniqueIdGeneratorCommand to set
	 */
	public void setUniqueIdGeneratorCommand(
			UniqueIdGeneratorCommand uniqueIdGeneratorCommand) {
		this.uniqueIdGeneratorCommand = uniqueIdGeneratorCommand;
	}

	@Async("generateBBCPEAssetsCommandExecutor")
	public void execute(Object vo) {
		Long recordCount = (Long) vo;
		for (int i = 0; i < recordCount / batchSize; i++) {
			List<BBCPEAsset> list = new ArrayList<BBCPEAsset>();
			Date d1 = new Date();
			for (int j = 0; j < batchSize; j++) {
				UniqueIDVO uniqueIDVO = new UniqueIDVO();
				uniqueIdGeneratorCommand.execute(uniqueIDVO);
				list.add(populateBbcpeAsset(uniqueIDVO));
			}
			Date d2 = new Date();
			System.out.println("Time spent creating batch id : " + i + " is : "
					+ (d2.getTime() - d1.getTime()));
			System.out.println("Bulk execution of batch : " + i);
			Map<Integer, List<BBCPEAsset>> map = new HashMap<Integer, List<BBCPEAsset>>();
			map.put(i, list);
			bulkUploadToHyperledgerCommand.execute(map);
		}
	}

	private BBCPEAsset populateBbcpeAsset(UniqueIDVO uniqueIDVO) {
		BBCPEAsset bbcpeAsset = new BBCPEAsset();
		bbcpeAsset.setCustomerId(Long.toString(uniqueIDVO.getCustomerId()));
		bbcpeAsset.setBbcpe(populateBbcpe(uniqueIDVO));
		return bbcpeAsset;
	}

	private BBCPE populateBbcpe(UniqueIDVO uniqueIDVO) {
		BBCPE bbcpe = new BBCPE();
		bbcpe.setFoId(Long.toString(uniqueIDVO.getFulfilmentOrderId()));
		bbcpe.setPoId(Long.toString(uniqueIDVO.getProductOrderId()));
		bbcpe.setOrderType("REGRADE");
		bbcpe.setCompletionDate("2018/09/29");
		bbcpe.setDn("0123456789");
		bbcpe.setJiffyBagSKU("EESH1-E");
		bbcpe.setMacAddress("00:0a:95:9d:68:16");
		bbcpe.setOrderDate("2018/09/29");
		bbcpe.setProductOrderType("REGRADE");
		bbcpe.setProductSKU("EE Wireless Router");
		bbcpe.setQuantity("1");
		bbcpe.setReason("New");
		bbcpe.setSerialNumber("123456789");
		bbcpe.setStatus("Completed");
		bbcpe.setSupplierId("123456789");
		return bbcpe;
	}
}
