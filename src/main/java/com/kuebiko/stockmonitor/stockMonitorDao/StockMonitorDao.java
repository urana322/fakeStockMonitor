package com.kuebiko.stockmonitor.stockMonitorDao;

import com.kuebiko.stockmonitor.stockMonitorModels.StockMonitor;

public interface StockMonitorDao {

    public StockMonitor find(String symbol);

}
