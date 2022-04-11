package com.kuebiko.stockmonitor.stockMonitorService;

import com.kuebiko.stockmonitor.stockMonitorModels.StockMonitor;
import org.springframework.stereotype.Service;

@Service
public interface StockMonitorService {

    public StockMonitor monitorStock(String symbol);

}
