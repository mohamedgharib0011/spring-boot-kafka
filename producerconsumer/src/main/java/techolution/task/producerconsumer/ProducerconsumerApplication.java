package techolution.task.producerconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ProducerconsumerApplication implements CommandLineRunner {

	@Autowired
	private Producer producer;

	@Value("${app.topic.techolution}")
	private String techolutionTopic;

	public static void main(String[] args) {
		SpringApplication.run(ProducerconsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.send(techolutionTopic, "Hello, I'm here");

	}

}
