package com.kuebiko.stockmonitor.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class StockMonitorDto {
    @Id
    private Long id;
    private String symbol;
    private double price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
