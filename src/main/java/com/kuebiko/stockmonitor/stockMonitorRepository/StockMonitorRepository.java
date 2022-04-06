package com.kuebiko.stockmonitor.stockMonitorRepository;

import com.kuebiko.stockmonitor.stockMonitorDto.StockMonitorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMonitorRepository extends JpaRepository <StockMonitorDto, Long> {
}
