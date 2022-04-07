package com.kuebiko.stockmonitor.repo;

import com.kuebiko.stockmonitor.dto.StockInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockInfoRepo extends JpaRepository<StockInfoDto,Long> {
}
