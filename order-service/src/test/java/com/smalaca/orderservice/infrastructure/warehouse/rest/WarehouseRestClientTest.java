package com.smalaca.orderservice.infrastructure.warehouse.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WarehouseRestClientTest {
    private final WarehouseServiceContract contract = new WarehouseServiceContract();

    @Autowired private WarehouseRestClient warehouseRestClient;

    @Test
    void shouldReturnFoundItems() {
        WarehouseServiceScenario scenario = contract.existingItems();

        List<ItemDto> actual = warehouseRestClient.findItems(scenario.searchCriteria());

        assertThat(actual).containsExactlyInAnyOrderElementsOf(scenario.expectedItems());
    }

    @Test
    void shouldReturnNoItemsWhenNothingFound() {
        WarehouseServiceScenario scenario = contract.notExistingItems();

        List<ItemDto> actual = warehouseRestClient.findItems(scenario.searchCriteria());

        assertThat(actual).containsExactlyInAnyOrderElementsOf(scenario.expectedItems());
    }
}
