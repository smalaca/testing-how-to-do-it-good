package com.smalaca.orderservice.infrastructure.warehouse.rest;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class WarehouseServiceContract {
    WarehouseServiceScenario existingItems() {
        return new WarehouseServiceScenario("Clean Code", asList(
                new ItemDto(2, "Clean Code: A Handbook of Agile Software Craftsmanship", 110, "PLN"),
                new ItemDto(6, "The Clean Coder: A Code of Conduct for Professional Programmers", 70, "PLN")
        ));
    }

    WarehouseServiceScenario notExistingItems() {
        return new WarehouseServiceScenario("Not so clean code", emptyList());
    }
}
