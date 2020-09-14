package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.infrastructure.warehouse.rest.ItemDto;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseRestClient;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class OfferApplicationService {
    private final WarehouseRestClient warehouseRestClient;

    OfferApplicationService(WarehouseRestClient warehouseRestClient) {
        this.warehouseRestClient = warehouseRestClient;
    }

    public List<OfferItemDto> find(String search) {
        List<ItemDto> items = warehouseRestClient.findItems(search);

        return items.stream()
                .map(item -> new OfferItemDto(item.getId(), item.getName(), withDiscount(item)))
                .collect(toList());
    }

    private OfferItemPriceDto withDiscount(ItemDto itemDto) {
        return new OfferItemPriceDto(withDiscount(itemDto.getAmount()), itemDto.getCurrency());
    }

    private double withDiscount(int amount) {
        return amount;
    }
}
