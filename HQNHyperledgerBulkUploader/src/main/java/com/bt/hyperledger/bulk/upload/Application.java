package com.bt.hyperledger.bulk.upload;

import java.util.concurrent.Executor;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.bt.hyperledger.bulk.upload.commands.BulkUploadToHyperledgerCommand;
import com.bt.hyperledger.bulk.upload.commands.GenerateBBCPEAssetsCommand;
import com.bt.hyperledger.bulk.upload.commands.UniqueIdGeneratorCommand;
import com.bt.hyperledger.bulk.upload.commands.UploadBBCPEToHyperledgerCommand;

@SpringBootApplication
@EnableAsync
public class Application {
	
	@Value("${bulk.upload.to.hyperledger.executor.core.pool.size}")
	private String BULK_UPLOAD_TO_HYPERLEDGER_EXECUTOR_CORE_POOL_SIZE;
	@Value("${bulk.upload.to.hyperledger.executor.max.pool.size}")
	private String BULK_UPLOAD_TO_HYPERLEDGER_EXECUTOR_MAX_POOL_SIZE;
	@Value("${bulk.upload.to.hyperledger.executor.queue.capacity}")
	private String BULK_UPLOAD_TO_HYPERLEDGER_EXECUTOR_QUEUE_CAPACITY;
	@Value("${bulk.upload.to.hyperledger.executor.thread.name.prefix}")
	private String BULK_UPLOAD_TO_HYPERLEDGER_EXECUTOR_THREAD_NAME_PREFIX;

	@Value("${upload.bbcpe.to.hyperledger.executor.core.pool.size}")
	private String UPLOAD_BBCPE_TO_HYPERLEDGER_EXECUTOR_CORE_POOL_SIZE;
	@Value("${upload.bbcpe.to.hyperledger.executor.max.pool.size}")
	private String UPLOAD_BBCPE_TO_HYPERLEDGER_EXECUTOR_MAX_POOL_SIZE;
	@Value("${upload.bbcpe.to.hyperledger.executor.queue.capacity}")
	private String UPLOAD_BBCPE_TO_HYPERLEDGER_EXECUTOR_QUEUE_CAPACITY;
	@Value("${upload.bbcpe.to.hyperledger.executor.thread.name.prefix}")
	private String UPLOAD_BBCPE_TO_HYPERLEDGER_EXECUTOR_THREAD_NAME_PREFIX;
	
	@Value("${generate.bbcpe.assets.executor.core.pool.size}")
	private String GENERATE_BBCPE_ASSETS_EXECUTOR_CORE_POOL_SIZE;
	@Value("${generate.bbcpe.assets.executor.max.pool.size}")
	private String GENERATE_BBCPE_ASSETS_EXECUTOR_MAX_POOL_SIZE;
	@Value("${generate.bbcpe.assets.executor.queue.capacity}")
	private String GENERATE_BBCPE_ASSETS_EXECUTOR_QUEUE_CAPACITY;
	@Value("${generate.bbcpe.assets.executor.thread.name.prefix}")
	private String GENERATE_BBCPE_ASSETS_EXECUTOR_THREAD_NAME_PREFIX;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public GenerateBBCPEAssetsCommand generateBBCPEAssetsCommand() {
		return new GenerateBBCPEAssetsCommand();
	}

	@Bean
	public BulkUploadToHyperledgerCommand bulkUploadToHyperledgerCommand() {
		return new BulkUploadToHyperledgerCommand();
	}

	@Bean 
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(6);
        template.setRequestFactory(new HttpComponentsClientHttpRequestFactory(HttpClients.custom().setConnectionManager(connectionManager).build()));
        return template;
    }

	@Bean
	public UniqueIdGeneratorCommand uniqueIdGeneratorCommand() {
		return new UniqueIdGeneratorCommand();
	}
	
	@Bean
	public UploadBBCPEToHyperledgerCommand uploadBBCPEToHyperledgerCommand() {
		return new  UploadBBCPEToHyperledgerCommand(restTemplate());
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	};
	
	@Bean
    public Executor bulkUploadToHyperledgerCommandExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Integer.parseInt(BULK_UPLOAD_TO_HYPERLEDGER_EXECUTOR_CORE_POOL_SIZE));
        executor.setMaxPoolSize(Integer.parseInt(BULK_UPLOAD_TO_HYPERLEDGER_EXECUTOR_MAX_POOL_SIZE));
        executor.setQueueCapacity(Integer.parseInt(BULK_UPLOAD_TO_HYPERLEDGER_EXECUTOR_QUEUE_CAPACITY));
        executor.setThreadNamePrefix(BULK_UPLOAD_TO_HYPERLEDGER_EXECUTOR_THREAD_NAME_PREFIX);
        executor.initialize();
        return executor;
    }
	
	@Bean
    public Executor uploadBBCPEToHyperledgerCommandExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Integer.parseInt(UPLOAD_BBCPE_TO_HYPERLEDGER_EXECUTOR_CORE_POOL_SIZE));
        executor.setMaxPoolSize(Integer.parseInt(UPLOAD_BBCPE_TO_HYPERLEDGER_EXECUTOR_MAX_POOL_SIZE));
        executor.setQueueCapacity(Integer.parseInt(UPLOAD_BBCPE_TO_HYPERLEDGER_EXECUTOR_QUEUE_CAPACITY));
        executor.setThreadNamePrefix(UPLOAD_BBCPE_TO_HYPERLEDGER_EXECUTOR_THREAD_NAME_PREFIX);
        executor.initialize();
        return executor;
    }
	
	@Bean
	public Executor generateBBCPEAssetsCommandExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(Integer.parseInt(GENERATE_BBCPE_ASSETS_EXECUTOR_CORE_POOL_SIZE));
		executor.setMaxPoolSize(Integer.parseInt(GENERATE_BBCPE_ASSETS_EXECUTOR_MAX_POOL_SIZE));
		executor.setQueueCapacity(Integer.parseInt(GENERATE_BBCPE_ASSETS_EXECUTOR_QUEUE_CAPACITY));
		executor.setThreadNamePrefix(GENERATE_BBCPE_ASSETS_EXECUTOR_THREAD_NAME_PREFIX);
		executor.initialize();
		return executor;
	}

}
