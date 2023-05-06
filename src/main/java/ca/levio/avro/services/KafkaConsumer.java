package ca.levio.avro.services;

import ca.levio.avro.messages.avro.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    @KafkaListener(topics = "${kafka.consumer.user.topic}", groupId = "${kafka.consumer.user.group}")
    public void userConsumer(ConsumerRecord<String, User> record) {
        System.out.println("Here is the user :");
        System.out.println("name : " + record.value().getName());
        System.out.println("age : " + record.value().getAge());
        System.out.println("**********");
        System.out.println(record.value().toString());
        System.out.println("**********");
    }
}


