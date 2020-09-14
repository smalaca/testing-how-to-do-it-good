package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.infrastructure.warehouse.rest.ItemDto;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseRestClient;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class OfferApplicationService {
    private final WarehouseRestClient warehouseRestClient;
    private final DiscountStrategy discountStrategy;

    OfferApplicationService(WarehouseRestClient warehouseRestClient, DiscountStrategy discountStrategy) {
        this.warehouseRestClient = warehouseRestClient;
        this.discountStrategy = discountStrategy;
    }

    public List<OfferItemDto> find(String search) {
        List<ItemDto> items = warehouseRestClient.findItems(search);

        return items.stream()
                .map(item -> new OfferItemDto(item.getId(), item.getName(), withDiscount(item)))
                .collect(toList());
    }

    private OfferItemPriceDto withDiscount(ItemDto itemDto) {
        return new OfferItemPriceDto(amount(itemDto), itemDto.getCurrency());
    }

    private double amount(ItemDto itemDto) {
        return discountStrategy.withDiscount(itemDto.getAmount());
    }
}
