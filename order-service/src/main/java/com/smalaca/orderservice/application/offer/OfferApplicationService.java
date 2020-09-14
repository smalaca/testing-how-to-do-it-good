package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.infrastructure.warehouse.rest.ItemDto;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseRestClient;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class OfferApplicationService {
    private final WarehouseRestClient warehouseRestClient;
    private final OfferItemDtoFactory offerItemDtoFactory;

    OfferApplicationService(WarehouseRestClient warehouseRestClient, OfferItemDtoFactory offerItemDtoFactory) {
        this.warehouseRestClient = warehouseRestClient;
        this.offerItemDtoFactory = offerItemDtoFactory;
    }

    public List<OfferItemDto> find(String search) {
        List<ItemDto> items = warehouseRestClient.findItems(search);

        return items.stream()
                .map(offerItemDtoFactory::create)
                .collect(toList());
    }
}
