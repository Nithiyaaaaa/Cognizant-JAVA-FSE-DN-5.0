package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;

    @Column(name = "st_code")
    private String code;

    @Column(name = "st_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "st_open")
    private Double open;

    @Column(name = "st_close")
    private Double close;

    @Column(name = "st_volume")
    private long volume;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public Double getOpen() { return open; }
    public void setOpen(Double open) { this.open = open; }
    public Double getClose() { return close; }
    public void setClose(Double close) { this.close = close; }
    public long getVolume() { return volume; }
    public void setVolume(long volume) { this.volume = volume; }

    @Override
    public String toString() {
        return "Stock{id=" + id + ", code='" + code + "', date=" + date +
                ", open=" + open + ", close=" + close + ", volume=" + volume + "}";
    }
}