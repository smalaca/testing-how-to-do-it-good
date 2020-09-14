package com.smalaca.orderservice.infrastructure.warehouse.rest;

import org.assertj.core.api.Assertions;

import java.util.List;

class ItemsDtoAssertion {
    private final List<ItemDto> actual;

    private ItemsDtoAssertion(List<ItemDto> actual) {
        this.actual = actual;
    }

    static ItemsDtoAssertion assertThat(List<ItemDto> actual) {
        return new ItemsDtoAssertion(actual);
    }

    ItemsDtoAssertion hasItems(int expected) {
        Assertions.assertThat(actual).hasSize(expected);
        return this;
    }

    ItemsDtoAssertion hasNoItems() {
        Assertions.assertThat(actual).isEmpty();
        return this;
    }

    ItemsDtoAssertion has(ItemDtoExpectation.Builder builder) {
        ItemDtoExpectation expectation = builder.build();
        Assertions.assertThat(actual).anySatisfy(expectation::satisfied);

        return this;
    }
}
