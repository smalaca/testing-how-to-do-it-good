package com.smalaca.orderservice.infrastructure.warehouse.rest;

import java.util.List;

public class WarehouseServiceScenario {
    private final String searchCriteria;
    private final List<ItemDto> items;

    WarehouseServiceScenario(String searchCriteria, List<ItemDto> items) {
        this.searchCriteria = searchCriteria;
        this.items = items;
    }

    public String searchCriteria() {
        return searchCriteria;
    }

    public List<ItemDto> expectedItems() {
        return items;
    }
}
