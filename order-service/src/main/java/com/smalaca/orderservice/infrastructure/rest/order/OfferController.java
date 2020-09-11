package com.smalaca.orderservice.infrastructure.rest.order;

import com.smalaca.orderservice.application.order.OfferItemDto;
import com.smalaca.orderservice.application.order.OfferItemPriceDto;
import com.smalaca.warehouse.client.rest.Item;
import com.smalaca.warehouse.client.rest.Price;
import com.smalaca.warehouse.client.rest.WarehouseClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/offer")
public class OfferController {
    private final WarehouseClient warehouseClient;

    public OfferController(WarehouseClient warehouseClient) {
        this.warehouseClient = warehouseClient;
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

        List<Item> items = warehouseClient.findItems(search);

        return items.stream()
                .map(item -> new OfferItemDto(item.getId(), item.getName(), withDiscount(item.getPrice())))
                .collect(toList());
    }

    private OfferItemPriceDto withDiscount(Price price) {
        return new OfferItemPriceDto(price.getAmount(), price.getCurrency().toString());
    }
}
