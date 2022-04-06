package com.kuebiko.stockmonitor.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StockMonitorKafkaListeners {

    // this will subscribe to our Kafka on the topic Fake Alert
    @KafkaListener(topics = "STOCK-MONITORING-TOPIC")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in Group 0: " + message);
    }


}
