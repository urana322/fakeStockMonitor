package com.kuebiko.stockmonitor.stockMonitorDao;


import com.kuebiko.stockmonitor.stockMonitorDto.StockMonitorDto;
import com.kuebiko.stockmonitor.stockMonitorModels.StockMonitor;
import com.kuebiko.stockmonitor.stockMonitorRepository.StockMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockMonitorDaoImpl implements StockMonitorDao {

    @Autowired
    StockMonitorRepository stockMonitorRepository;

    @Override
    public StockMonitor save (StockMonitor stockMonitor) {


        String symbol = stockMonitor.getSymbol();
        Double price = stockMonitor.getPrice();
        String date = stockMonitor.getDate();


        StockMonitorDto toSave = new StockMonitorDto();

        toSave.setSymbol(symbol);
        toSave.setPrice(price);
        toSave.setDate(date);
        toSave.setId(System.currentTimeMillis());

        StockMonitorDto saveDataFromDb = stockMonitorRepository.save(toSave);

        StockMonitor response = new StockMonitor();
        response.setId(saveDataFromDb.getId());
        response.setSymbol(saveDataFromDb.getSymbol());
        response.setPrice(saveDataFromDb.getPrice());
        response.setDate(saveDataFromDb.getDate());

        return response;
    }

    @Override
    public StockMonitorDto find(String symbol) {
        return null;
    }


}
