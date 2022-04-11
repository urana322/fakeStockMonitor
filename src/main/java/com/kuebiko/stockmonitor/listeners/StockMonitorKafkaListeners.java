package com.kuebiko.stockmonitor.listeners;

import com.kuebiko.stockmonitor.stockMonitorDao.StockMonitorDao;
import com.kuebiko.stockmonitor.stockMonitorDto.StockMonitorDto;
import com.kuebiko.stockmonitor.stockMonitorModels.StockMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StockMonitorKafkaListeners {

    @Autowired
    StockMonitorDao stockMonitorDao;
    // this will subscribe to our Kafka on the topic Fake Alert
    @KafkaListener(topics = "STOCK-MONITORING-TOPIC", groupId = "0")
    public void listenGroupFoo(String message) throws ParseException {

        System.out.println("Received Message in Group 0: " + message);

        StockMonitor stockMonitors = convertStringToModel(message);
        stockMonitorDao.save(stockMonitors);

    }

    private StockMonitor convertStringToModel(String message) throws ParseException {
        String splitMessage[] = message.split("$");
        String symbol = splitMessage[0];
        Double price = Double.valueOf(splitMessage[1]);
        Date date = new SimpleDateFormat("mm/dd/yyyy")
                .parse(splitMessage[2]);

        StockMonitor stockMonitors = new StockMonitor();
        stockMonitors.setSymbol(symbol);
        stockMonitors.setPrice(price);
        stockMonitors.setDate(date);
        return stockMonitors;
    }

}
