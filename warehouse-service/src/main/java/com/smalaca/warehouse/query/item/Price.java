package com.smalaca.warehouse.query.item;

public class Price {
    private final int amount;
    private final Currency currency;

    private Price(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Price price(int amount, Currency currency) {
        return new Price(amount, currency);
    }

    public int getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
