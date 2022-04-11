package com.kuebiko.stockmonitor.stockMonitorService;

import com.kuebiko.stockmonitor.stockMonitorDao.StockMonitorDao;
import com.kuebiko.stockmonitor.stockMonitorModels.StockMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockMonitorServiceImpl implements StockMonitorService {

    @Autowired
    StockMonitorDao stockMonitorDao;

    @Override
    public StockMonitor monitorStock(String symbol) {

        return stockMonitorDao.find(symbol);
    }

}
