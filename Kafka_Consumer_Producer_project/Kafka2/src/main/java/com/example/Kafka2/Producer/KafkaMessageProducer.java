package com.example.Kafka2.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProducer {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Value("${kafka.topic}")
    String topic;

    public void SendMessage(String message)
    {
        kafkaTemplate.send(topic,message);
    }


}
