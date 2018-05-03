package com.marketplace.order.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.marketplace.order.domains.Item;



public class Producer {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private KafkaTemplate<String, Item> kafkaTemplate;
	
	@Value("${spring.kafka.topic}")
	private String kafkaTopic;
	
	public void send(Item data) {
	    LOG.info("sending data='{}'", data);
	    
	    ListenableFuture<SendResult<String, Item>> future = kafkaTemplate.send(kafkaTopic, "3", data);

	    // you can register a callback with the listener to receive the result
	    // of the send asynchronously
	    future.addCallback(new ListenableFutureCallback<SendResult<String, Item>>() {

		    	@Override
		    	public void onSuccess(SendResult<String, Item> result) {
		    		LOG.info("sent message='{}' with offset={}", data, result.getRecordMetadata().offset());
		    	}
		    	@Override
		    	public void onFailure(Throwable ex) {
		    		LOG.error("unable to send message='{}'", data, ex);
		    	}
	    });
	}
}
