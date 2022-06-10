package com.kuebiko.stockmonitor.stockMonitorDao;


import com.kuebiko.stockmonitor.stockMonitorRepository.StockMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockMonitorDaoImpl {

    @Autowired
    StockMonitorRepository stockMonitorRepository;


}
