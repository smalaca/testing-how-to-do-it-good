package com.smalaca.orderservice.infrastructure.warehouse.rest;

import com.smalaca.warehouse.client.rest.Currency;
import com.smalaca.warehouse.client.rest.Item;
import com.smalaca.warehouse.client.rest.WarehouseClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class WarehouseRestClientTest {
    @Autowired private WarehouseClient warehouseClient;

    @Test
    void shouldReturnFoundItems() {
        List<Item> actual = warehouseClient.findItems("Clean Code");

        assertThat(actual).hasSize(2)
                .anySatisfy(item -> {
                    assertThat(item.getId()).isEqualTo(2);
                    assertThat(item.getName()).isEqualTo("Clean Code: A Handbook of Agile Software Craftsmanship");
                    assertThat(item.getPrice().getAmount()).isEqualTo(110);
                    assertThat(item.getPrice().getCurrency()).isEqualTo(Currency.PLN);
                })
                .anySatisfy(item -> {
                    assertThat(item.getId()).isEqualTo(6);
                    assertThat(item.getName()).isEqualTo("The Clean Coder: A Code of Conduct for Professional Programmers");
                    assertThat(item.getPrice().getAmount()).isEqualTo(70);
                    assertThat(item.getPrice().getCurrency()).isEqualTo(Currency.PLN);
                });
    }

    @Test
    void shouldThrowHttpNotFound() {
        assertThrows(HttpClientErrorException.NotFound.class, () -> warehouseClient.findItems("Not so clean code"));
    }
}
