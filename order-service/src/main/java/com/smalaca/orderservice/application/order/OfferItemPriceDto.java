package com.smalaca.orderservice.application.order;

public class OfferItemPriceDto {
    private final int amount;
    private final String currency;

    public OfferItemPriceDto(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
