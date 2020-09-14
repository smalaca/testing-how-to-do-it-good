package com.smalaca.orderservice.infrastructure.warehouse.rest;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ItemDto itemDto = (ItemDto) o;

        return new EqualsBuilder()
                .append(id, itemDto.id)
                .append(amount, itemDto.amount)
                .append(name, itemDto.name)
                .append(currency, itemDto.currency)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(amount)
                .append(currency)
                .toHashCode();
    }
}
