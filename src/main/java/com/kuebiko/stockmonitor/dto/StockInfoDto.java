package com.kuebiko.stockmonitor.dto;

import org.springframework.kafka.annotation.EnableKafka;

import javax.persistence.Id;
import java.util.Date;

@EnableKafka
public class StockInfoDto {

    @Id
    private Long id;
    private String symbol;
    private String price;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
