package com.kuebiko.stockmonitor.stockMonitorDao;

import com.kuebiko.stockmonitor.stockMonitorDto.StockMonitorDto;
import com.kuebiko.stockmonitor.stockMonitorModels.StockMonitor;

public interface StockMonitorDao {

    public StockMonitor save (StockMonitor stockMonitor);

    public StockMonitorDto find(String symbol);

}
