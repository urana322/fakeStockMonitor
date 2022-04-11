package com.kuebiko.stockmonitor.listeners;

import com.kuebiko.stockmonitor.stockMonitorDao.StockMonitorDao;
import com.kuebiko.stockmonitor.stockMonitorDto.StockMonitorDto;
import com.kuebiko.stockmonitor.stockMonitorModels.StockMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StockMonitorKafkaListeners {

    @Autowired
    StockMonitorDao stockMonitorDao;

    // this will subscribe to our Kafka on the topic Fake Alert
    @KafkaListener(topics = "STOCK-MONITORING-TOPIC")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in Group 0: " + message);

        //need to map model variable (dataToSave) with dao
        StockMonitor dataToSave = convertStringToModel(message);

        //call dao.save(dataToSave)
        stockMonitorDao.save(dataToSave);
    }

    private StockMonitor convertStringToModel(String message) {

        //message: "AAPL - 170.70 - 04/11/2022 09:30:00"
        String arrString [] = message.split(" - ");

        //Create a model class StockMonitor
        StockMonitor stockMonitor = new StockMonitor();

        //set the value
        stockMonitor.setSymbol(arrString[0]);
        stockMonitor.setPrice(Double.valueOf(arrString[1]));
        stockMonitor.setDate(arrString[2]);

        //call dao and pass model class
        StockMonitor dataToSave = stockMonitorDao.save(stockMonitor);

        return dataToSave;
    }


}
