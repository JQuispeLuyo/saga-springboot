package com.jquispeluyo.productos.helpers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestListener {

    @KafkaListener(topics = "cuentaservice", groupId = "0")
    public void processMessage(String content) {
        System.out.println(content);
    }

}
