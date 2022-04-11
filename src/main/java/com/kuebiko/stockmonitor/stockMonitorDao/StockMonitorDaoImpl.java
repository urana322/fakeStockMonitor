package com.kuebiko.stockmonitor.stockMonitorDao;


import com.kuebiko.stockmonitor.stockMonitorDto.StockMonitorDto;
import com.kuebiko.stockmonitor.stockMonitorModels.StockMonitor;
import com.kuebiko.stockmonitor.stockMonitorRepository.StockMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StockMonitorDaoImpl implements StockMonitorDao{

    @Autowired
    StockMonitorRepository stockMonitorRepository;


    @Override
    public StockMonitor find(String symbol) {

        return null;
    }

    @Override
    public StockMonitor save(StockMonitor info) {

        String symbol= info.getSymbol();
        Double price = info.getPrice();
        Date date= info.getDate();

        StockMonitorDto toSave= new StockMonitorDto();

        toSave.setSymbol(symbol);
        toSave.setPrice(price);
        toSave.setDate(date);

        //Saving to database
        StockMonitorDto mySaveDataFromDatabase = stockMonitorRepository.save(toSave);

        StockMonitor response = new StockMonitor();

        response.setSymbol(mySaveDataFromDatabase.getSymbol());
        response.setPrice(mySaveDataFromDatabase.getPrice());
        response.setDate(mySaveDataFromDatabase.getDate());

        return response;
    }
}
