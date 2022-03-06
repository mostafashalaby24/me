package com.example.Kafka2.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class KafkaEvenListener {

    @KafkaListener(topics = "${kafka.topic}")
    public void listen(Message<String> message)
    {
        String payload =message.getPayload();
        System.out.println(payload);

    }

}
