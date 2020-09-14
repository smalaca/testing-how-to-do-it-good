package com.smalaca.orderservice.infrastructure.warehouse.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WarehouseRestClientTest {
    @Autowired private WarehouseRestClient warehouseRestClient;

    @Test
    void shouldReturnFoundItems() {
        List<ItemDto> actual = warehouseRestClient.findItems("Clean Code");

        assertThat(actual).hasSize(2)
                .anySatisfy(item -> {
                    ItemDtoAssertion.assertThat(item)
                            .hasId(2)
                            .hasName("Clean Code: A Handbook of Agile Software Craftsmanship")
                            .hasPrice(110, "PLN");
                })
                .anySatisfy(item -> {
                    assertThat(item.getId()).isEqualTo(6);
                    assertThat(item.getName()).isEqualTo("The Clean Coder: A Code of Conduct for Professional Programmers");
                    assertThat(item.getAmount()).isEqualTo(70);
                    assertThat(item.getCurrency()).isEqualTo("PLN");
                });
    }

    @Test
    void shouldReturnNoItemsWhenNothingFound() {
        List<ItemDto> actual = warehouseRestClient.findItems("Not so clean code");

        assertThat(actual).isEmpty();
    }
}
