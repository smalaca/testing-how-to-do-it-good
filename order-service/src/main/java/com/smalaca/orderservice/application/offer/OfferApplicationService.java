package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseRestClient;

import java.util.Collections;
import java.util.List;

public class OfferApplicationService {
    private final WarehouseRestClient warehouseRestClient;

    OfferApplicationService(WarehouseRestClient warehouseRestClient) {
        this.warehouseRestClient = warehouseRestClient;
    }

    public List<OfferItemDto> find(String search) {
        return Collections.emptyList();
    }
}
