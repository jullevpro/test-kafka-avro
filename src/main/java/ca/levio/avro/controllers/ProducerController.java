package ca.levio.avro.controllers;

import ca.levio.avro.dtos.UserDto;
import ca.levio.avro.messages.avro.User;
import ca.levio.avro.services.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce/user")
public class ProducerController {

    private final KafkaProducer kafkaProducer;

    public ProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public UserDto produceMessage(@RequestBody UserDto user) {
        return kafkaProducer.sendMessage(user);

    }
}
