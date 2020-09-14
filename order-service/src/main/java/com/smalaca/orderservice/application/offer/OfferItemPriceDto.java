package com.smalaca.orderservice.application.offer;

public class OfferItemPriceDto {
    private final double amount;
    private final String currency;

    public OfferItemPriceDto(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
