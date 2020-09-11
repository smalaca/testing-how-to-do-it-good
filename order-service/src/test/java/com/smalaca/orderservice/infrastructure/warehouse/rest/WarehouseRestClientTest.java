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
                    assertThat(item.getId()).isEqualTo(2);
                    assertThat(item.getName()).isEqualTo("Clean Code: A Handbook of Agile Software Craftsmanship");
                    assertThat(item.getAmount()).isEqualTo(110);
                    assertThat(item.getCurrency()).isEqualTo("PLN");
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
