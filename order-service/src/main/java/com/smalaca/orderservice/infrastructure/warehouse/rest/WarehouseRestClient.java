package com.smalaca.orderservice.infrastructure.warehouse.rest;

import com.smalaca.warehouse.client.rest.Item;
import com.smalaca.warehouse.client.rest.WarehouseClient;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WarehouseRestClient {
    private final WarehouseClient warehouseClient;

    WarehouseRestClient(WarehouseClient warehouseClient) {
        this.warehouseClient = warehouseClient;
    }

    public List<ItemDto> findItems(String search) {
        return getItems(search).stream()
                .map(this::asItemDto)
                .collect(toList());
    }

    private List<Item> getItems(String search) {
        try {
            return warehouseClient.findItems(search);
        } catch (HttpClientErrorException.NotFound exception) {
            return Collections.emptyList();
        }
    }

    private ItemDto asItemDto(Item item) {
        return new ItemDto(item.getId(), item.getName(), item.getPrice().getAmount(), item.getPrice().getCurrency().toString());
    }
}
