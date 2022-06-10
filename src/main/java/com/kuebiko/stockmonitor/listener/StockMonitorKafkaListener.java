package com.kuebiko.stockmonitor.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StockMonitorKafkaListener {
    @KafkaListener(topics = "STOCK-MONITORING-TOPIC", groupId = "foo")
    public void listener(String message) {

        // FORMAT
        // message = "AMA & 102 & 2022-02-02";
        System.out.println("Received a message " + message);
    }
}
