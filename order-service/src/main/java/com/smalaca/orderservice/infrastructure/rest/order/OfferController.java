package com.smalaca.orderservice.infrastructure.rest.order;

import com.smalaca.orderservice.application.order.OfferItemDto;
import com.smalaca.orderservice.application.order.OfferItemPriceDto;
import com.smalaca.orderservice.infrastructure.warehouse.rest.ItemDto;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/offer")
public class OfferController {
    private final WarehouseRestClient warehouseRestClient;

    public OfferController(WarehouseRestClient warehouseRestClient) {
        this.warehouseRestClient = warehouseRestClient;
    }

    @GetMapping
    public List<OfferItemDto> find(@RequestParam String search) {
        /**
         * 1. Get items from warehouse service.
         * 2. Apply available discount:
         *      - 10% if December
         *      - 30% in September and October
         *      - 15% in March and April
         * 3. Send information back to user
         */
        List<ItemDto> items = warehouseRestClient.findItems(search);

        return items.stream()
                .map(item -> new OfferItemDto(item.getId(), item.getName(), withDiscount(item)))
                .collect(toList());
    }

    private OfferItemPriceDto withDiscount(ItemDto itemDto) {
        return new OfferItemPriceDto(itemDto.getAmount(), itemDto.getCurrency());
    }
}
