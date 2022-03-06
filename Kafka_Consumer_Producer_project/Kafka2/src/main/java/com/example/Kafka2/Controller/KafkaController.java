package com.example.Kafka2.Controller;

import com.example.Kafka2.Producer.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    KafkaMessageProducer kafkaMessageProducer;

    @PostMapping("/PushMessage")
    public String PostMessage(@RequestBody String message)
    {
            kafkaMessageProducer.SendMessage(message);
            return "Message Published";

    }


}
