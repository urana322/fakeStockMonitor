package com.kuebiko.stockmonitor.listeners;

import com.kuebiko.stockmonitor.stockMonitorDao.StockMonitorDao;
import com.kuebiko.stockmonitor.stockMonitorModels.StockMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class StockMonitorKafkaListeners {

    @Autowired
    StockMonitorDao stockMonitorDao;

    // this will subscribe to our Kafka on the topic Fake Alert
    @KafkaListener(topics = "STOCK-MONITORING-TOPIC", groupId = "0")
    public void listenGroupFoo(String message) {

        System.out.println("Received Message in Group 0: " + message);

        StockMonitor dataToSave = convertstringTOModel(message);
        // call dao.save(dataToSdave)

        stockMonitorDao.save(dataToSave);

    }

    private StockMonitor convertstringTOModel(String message) {
        // split the message using message.split('$')
        message = "Apple$150@04-12-2022";
        // string[] = 'APPL' '150' '2022-'
        String[] mess = message.split("$");
        String symbol = mess[0];
        String price = mess[1];
        String date = mess[2];
        // Create a model class StockMonitor
        StockMonitor stockMonitor = new StockMonitor();
        // set the values
        stockMonitor.setSymbol(symbol);
        stockMonitor.setPrice(Double.valueOf(price));
        stockMonitor.setDate(Date.valueOf(date));
        // call dao.save(model)
        return stockMonitor;
    }


}
