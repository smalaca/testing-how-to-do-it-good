package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.clock.Clock;
import com.smalaca.orderservice.infrastructure.warehouse.rest.ItemDto;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseRestClient;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class OfferApplicationService {
    private final WarehouseRestClient warehouseRestClient;
    private final Clock clock;

    OfferApplicationService(WarehouseRestClient warehouseRestClient, Clock clock) {
        this.warehouseRestClient = warehouseRestClient;
        this.clock = clock;
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
        LocalDate now = clock.now();

        switch (now.getMonth()) {
            case MARCH:
            case APRIL:
                return amount * 0.85;

            case SEPTEMBER:
            case OCTOBER:
                return amount * 0.7;

            case DECEMBER:
                return amount * 0.9;
        }

        return amount;

    }
}
