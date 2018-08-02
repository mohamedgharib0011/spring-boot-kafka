package techolution.task.producerconsumer;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Kafka Consumer
 * 
 * @author mgharib
 *
 */
@Service
public class Consumer {

	// used for testing purpose.
	CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	/**
	 * receive messages from Kafka configured topic
	 * 
	 * @param message
	 * @author mgharib
	 */
	@KafkaListener(topics = "${app.topic.techolution}")
	public void receive(@Payload String message) {
		System.out.println("Message Received: " + message);
		// mark that the message is received
		latch.countDown();
	}

}
