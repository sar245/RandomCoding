package com.bt.hyperledger.bulk.upload.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.bt.hyperledger.bulk.upload.beans.UniqueIDVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UniqueIdGeneratorCommand implements IHyperledgerBulkUploadCommand {

	private static final String ID_GENERATOR_FILE = "last_id.txt";
	private static final String INITIAL_DATA = "{\"customerId\":100000,\"productOrderId\":2000000,\"fulfilmentOrderId\":11100000}";

	@Override
	public synchronized void execute(Object vo) {
		try {
			UniqueIDVO uniqueIDVO = (UniqueIDVO) vo;
			ObjectMapper mapper = new ObjectMapper();
			File f = new File(ID_GENERATOR_FILE);
			if (!f.exists()) {
				System.out.println(2.1);
				f.createNewFile();
				Files.write(Paths.get(f.toURI()), INITIAL_DATA.getBytes());
			}
			String content = new String(Files.readAllBytes(f.toPath()));
			UniqueIDVO idFromFile = mapper.readValue(content, UniqueIDVO.class);
			uniqueIDVO.setCustomerId(idFromFile.getCustomerId() + 1);
			uniqueIDVO.setProductOrderId(idFromFile.getProductOrderId() + 1);
			uniqueIDVO.setFulfilmentOrderId(idFromFile.getFulfilmentOrderId() + 1);
			String json = mapper.writeValueAsString(uniqueIDVO);
			Files.write(Paths.get(f.toURI()), json.getBytes());
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
