package com.smalaca.orderservice.application.offer;

import static org.assertj.core.api.Assertions.assertThat;

class OfferItemDtoExpectation {
    private final int id;
    private final String name;
    private final double amount;
    private final String currency;

    private OfferItemDtoExpectation(Builder builder) {
        id = builder.id;
        name = builder.name;
        amount = builder.amount;
        currency = builder.currency;
    }

    void satisfied(OfferItemDto actual) {
        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getName()).isEqualTo(name);
        assertThat(actual.getPrice().getAmount()).isEqualTo(amount);
        assertThat(actual.getPrice().getCurrency()).isEqualTo(currency);
    }

    public static class Builder {
        private int id;
        private String name;
        private double amount;
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

        Builder withPrice(double amount, String currency) {
            this.amount = amount;
            this.currency = currency;
            return this;
        }

        OfferItemDtoExpectation build() {
            return new OfferItemDtoExpectation(this);
        }
    }
}
