package com.example.Kafka.Controller;

import com.example.Kafka.model.model;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class Controller {

    private KafkaTemplate<String, model> KafkaTemplate;


    @Autowired
    public Controller(KafkaTemplate<String, model> KafkaTemplate)
    {
        this.KafkaTemplate=KafkaTemplate;

    }

    @PostMapping
    public void Post(@RequestBody model model)
    {
        KafkaTemplate.send("MyTopic",model);

    }




}
