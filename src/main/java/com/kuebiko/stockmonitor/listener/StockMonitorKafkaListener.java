package com.kuebiko.stockmonitor.listener;

import org.springframework.kafka.annotation.KafkaListener;

public class StockMonitorKafkaListener {

    @KafkaListener(topics = "FAKE-BANK-ALERTS-TOPIC", groupId = "0")
    public void listenGroupFoo(String message) {

        System.out.println("Received Message in group foo: " + message);
    }

}
