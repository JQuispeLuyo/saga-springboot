package com.jhordyguerra.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyKafka {

    @Autowired
    private KafkaTemplate template;

    public void sendMessage(String message) {
        template.send("test", message);
    }

    /*@KafkaListener(topics = { "test" })
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("---->" + message);
        }
    }*/
}