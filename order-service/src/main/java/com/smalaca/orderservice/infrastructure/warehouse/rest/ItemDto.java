package com.smalaca.orderservice.infrastructure.warehouse.rest;

public class ItemDto {
    private final int id;
    private final String name;
    private final int amount;
    private final String currency;

    ItemDto(int id, String name, int amount, String currency) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
