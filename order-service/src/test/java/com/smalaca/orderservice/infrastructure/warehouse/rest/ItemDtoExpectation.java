package com.smalaca.orderservice.infrastructure.warehouse.rest;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDtoExpectation {
    private final int id;
    private final String name;
    private final int amount;
    private final String currency;

    private ItemDtoExpectation(Builder builder) {
        id = builder.id;
        name = builder.name;
        amount = builder.amount;
        currency = builder.currency;
    }

    void satisfied(ItemDto itemDto) {
        assertThat(itemDto.getId()).isEqualTo(id);
        assertThat(itemDto.getName()).isEqualTo(name);
        assertThat(itemDto.getAmount()).isEqualTo(amount);
        assertThat(itemDto.getCurrency()).isEqualTo(currency);
    }

    public static class Builder {
        private int id;
        private String name;
        private int amount;
        private String currency;

        static Builder item() {
            return new Builder();
        }

        Builder withId(int id) {
            this.id = id;
            return this;
        }

        Builder withName(String name) {
            this.name = name;
            return this;
        }

        Builder withPrice(int amount, String currency) {
            this.amount = amount;
            this.currency = currency;
            return this;
        }

        ItemDtoExpectation build() {
            return new ItemDtoExpectation(this);
        }
    }
}
