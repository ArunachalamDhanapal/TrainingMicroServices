package com.trigyn.priceservice.model;

public class Price {
    private String country;
    private Double conversionRate;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public String toString() {
        return "Price{" +
                "country='" + country + '\'' +
                ", conversionRate=" + conversionRate +
                '}';
    }
}