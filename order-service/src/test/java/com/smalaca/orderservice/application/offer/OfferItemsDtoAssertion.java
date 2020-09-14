package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.infrastructure.warehouse.rest.ItemDto;
import org.assertj.core.api.Assertions;

import java.util.List;

class OfferItemsDtoAssertion {
    private final List<OfferItemDto> actual;

    private OfferItemsDtoAssertion(List<OfferItemDto> actual) {
        this.actual = actual;
    }

    static OfferItemsDtoAssertion assertThat(List<OfferItemDto> actual) {
        return new OfferItemsDtoAssertion(actual);
    }

    OfferItemsDtoAssertion hasItems(int expected) {
        Assertions.assertThat(actual).hasSize(expected);
        return this;
    }

    OfferItemsDtoAssertion hasNoItems() {
        Assertions.assertThat(actual).isEmpty();
        return this;
    }

    OfferItemsDtoAssertion has(OfferItemDtoExpectation.Builder builder) {
        OfferItemDtoExpectation expectation = builder.build();
        Assertions.assertThat(actual).anySatisfy(expectation::satisfied);

        return this;
    }
}
