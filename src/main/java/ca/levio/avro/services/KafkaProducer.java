package ca.levio.avro.services;

import ca.levio.avro.dtos.UserDto;
import ca.levio.avro.messages.avro.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    @Value("${kafka.consumer.user.topic}")
    private String topicName;

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public UserDto sendMessage(UserDto userDto) {
        User user = new User(userDto.getName(), userDto.getAge());
        this.kafkaTemplate.send(this.topicName, user.getName(), user);
        return userDto;
    }
}
