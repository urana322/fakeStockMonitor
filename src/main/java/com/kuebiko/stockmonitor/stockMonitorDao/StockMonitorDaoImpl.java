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
    public void save(StockMonitor payload) {

        StockMonitorDto stockMonitorDto = new StockMonitorDto();
        stockMonitorDto.setSymbol(payload.getSymbol());
        stockMonitorDto.setPrice(payload.getPrice());
        stockMonitorDto.setDate(payload.getDate());

        stockMonitorRepository.save(stockMonitorDto);
    }

    @Override
    public StockMonitor find(String symbol) {
        StockMonitorDto infoFromDb = stockMonitorRepository.findBySymbol(symbol);
        StockMonitor response = new StockMonitor();
        response.setSymbol(infoFromDb.getSymbol());
        response.setPrice(infoFromDb.getPrice());
        response.setDate(infoFromDb.getDate());

        return response;
    }
}
