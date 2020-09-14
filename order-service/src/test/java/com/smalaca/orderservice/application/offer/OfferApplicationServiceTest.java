package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseRestClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class OfferApplicationServiceTest {
    private final WarehouseRestClient warehouseRestClient = mock(WarehouseRestClient.class);
    private final OfferApplicationService offerApplicationService = new OfferApplicationServiceFactory().create(warehouseRestClient);
}