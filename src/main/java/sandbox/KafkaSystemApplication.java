package sandbox;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class KafkaSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSystemApplication.class, args);
		log.info("test");
	}

}
