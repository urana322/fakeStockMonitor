package com.kuebiko.stockmonitor.stockMonitorRepository;

import com.kuebiko.stockmonitor.stockMonitorDto.StockMonitorDto;
import com.kuebiko.stockmonitor.stockMonitorModels.StockMonitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMonitorRepository extends JpaRepository <StockMonitorDto, Long> {
    @Query(
            value = "SELECT * FROM STOCK_MONITOR_DTO WHERE SYMBOL=?1",
            nativeQuery = true)
    public StockMonitorDto findBySymbol(String symbol);
}
