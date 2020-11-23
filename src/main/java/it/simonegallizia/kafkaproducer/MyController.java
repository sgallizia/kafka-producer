package it.simonegallizia.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	@PostMapping(path = "/publish")
	public String publish(@RequestBody String event) {
		kafkaTemplate.send("b2b-events", event != null ? event : "test");
		return event;
	}
}
