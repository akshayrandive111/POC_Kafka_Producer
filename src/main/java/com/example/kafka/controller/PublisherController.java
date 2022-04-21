package com.example.kafka.controller;

import com.example.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/publish/{name}")
    public String sendMessage(@PathVariable String name){
        kafkaTemplate.send("topic5","Hi "+name+" welcome to kafka demo!");
        return "Data Published!";
    }

    @GetMapping("/publishJson")
    public String sendMessage(){
        User user = new User(111,"Akshay",new String[]{"Pune","Hadapsar"});
        kafkaTemplate.send("topic5",user);
        return "Json Data Published!";
    }

}
