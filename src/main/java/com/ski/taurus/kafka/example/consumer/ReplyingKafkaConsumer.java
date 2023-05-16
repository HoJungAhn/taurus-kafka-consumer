package com.ski.taurus.kafka.example.consumer;

import com.ski.taurus.kafka.model.model.Model;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;


@Component
public class ReplyingKafkaConsumer {
	 
	 @KafkaListener(topics = "${kafka.topic.request-topic}")
	 @SendTo
	  public Model listen(Model request, @Header(KafkaHeaders.CORRELATION_ID) byte[] correlation) throws InterruptedException {
		 
		 int sum = request.getFirstNumber() + request.getSecondNumber();
		 request.setAdditionalProperty("sum", sum);
		 System.out.println("consume~!!!!");
		 return request;
	  }

}
