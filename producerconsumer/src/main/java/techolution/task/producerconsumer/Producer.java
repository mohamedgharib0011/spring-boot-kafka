package techolution.task.producerconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Kafka Producer
 * @author mgharib
 *
 */
@Service
public class Producer {

	@Autowired
	private KafkaTemplate<String, String> kafkatemplate;

	/**
	 * send messages to a kafka topic
	 * 
	 * @param topic : kafka topic
	 * @param message : message to be send to the passed topic
	 * @author mgharib
	 */
	public void send(String topic, String message) {
		kafkatemplate.send(topic, message);
	}
}
