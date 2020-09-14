package com.smalaca.orderservice.infrastructure.warehouse.rest;

import org.assertj.core.api.Assertions;

class ItemDtoAssertion {
    private final ItemDto actual;

    private ItemDtoAssertion(ItemDto actual) {
        this.actual = actual;
    }

    static ItemDtoAssertion assertThat(ItemDto actual) {
        return new ItemDtoAssertion(actual);
    }

    ItemDtoAssertion hasId(int expected) {
        Assertions.assertThat(actual.getId()).isEqualTo(expected);
        return this;
    }

    ItemDtoAssertion hasName(String expected) {
        Assertions.assertThat(actual.getName()).isEqualTo(expected);
        return this;
    }

    ItemDtoAssertion hasPrice(int amount, String currency) {
        Assertions.assertThat(actual.getAmount()).isEqualTo(amount);
        Assertions.assertThat(actual.getCurrency()).isEqualTo(currency);
        return this;
    }
}
