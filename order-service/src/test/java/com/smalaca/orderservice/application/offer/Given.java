package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.clock.Clock;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseRestClient;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseServiceScenario;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.BDDMockito.given;

class Given {
    private final WarehouseRestClient warehouseRestClient;
    private final Clock clock;

    Given(WarehouseRestClient warehouseRestClient, Clock clock) {
        this.warehouseRestClient = warehouseRestClient;
        this.clock = clock;
    }

    Given foundItemsFor(WarehouseServiceScenario scenario) {
        given(warehouseRestClient.findItems(scenario.searchCriteria())).willReturn(scenario.expectedItems());
        return this;
    }

    Given currentMonth(Month month) {
        given(clock.now()).willReturn(LocalDate.of(2020, month, 1));
        return this;
    }
}
