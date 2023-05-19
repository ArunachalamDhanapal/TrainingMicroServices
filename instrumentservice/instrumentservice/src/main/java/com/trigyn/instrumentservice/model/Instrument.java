package com.trigyn.instrumentservice.model;

public class Instrument {
    private String exchange;
    private Long currency;
    private Integer amount;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Long getCurrency() {
        return currency;
    }

    public void setCurrency(Long currency) {
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "exchange='" + exchange + '\'' +
                ", currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}