package com.smalaca.orderservice.infrastructure.warehouse.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.smalaca.orderservice.infrastructure.warehouse.rest.ItemDtoExpectation.Builder.item;
import static com.smalaca.orderservice.infrastructure.warehouse.rest.ItemsDtoAssertion.assertThat;

@SpringBootTest
class WarehouseRestClientTest {
    @Autowired private WarehouseRestClient warehouseRestClient;

    @Test
    void shouldReturnFoundItems() {
        List<ItemDto> actual = warehouseRestClient.findItems("Clean Code");

        assertThat(actual)
                .hasItems(2)
                .has(item()
                        .withId(2)
                        .withName("Clean Code: A Handbook of Agile Software Craftsmanship")
                        .withPrice(110, "PLN"))
                .has(item()
                        .withId(6)
                        .withName("The Clean Coder: A Code of Conduct for Professional Programmers")
                        .withPrice(70, "PLN"));
    }

    @Test
    void shouldReturnNoItemsWhenNothingFound() {
        List<ItemDto> actual = warehouseRestClient.findItems("Not so clean code");

        assertThat(actual).hasNoItems();
    }
}
