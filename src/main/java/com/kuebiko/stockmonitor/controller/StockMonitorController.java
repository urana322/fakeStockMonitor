package com.kuebiko.stockmonitor.controller;

import com.kuebiko.stockmonitor.stockMonitorModels.StockMonitor;
import com.kuebiko.stockmonitor.stockMonitorService.StockMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockMonitorController {

    @Autowired
    StockMonitorService stockMonitorService;

    @RequestMapping(value = "/stock-monitor", method = RequestMethod.GET)
    public StockMonitor monitorStock(@RequestParam String symbol){
        return stockMonitorService.monitorStock(symbol);
    }
}
