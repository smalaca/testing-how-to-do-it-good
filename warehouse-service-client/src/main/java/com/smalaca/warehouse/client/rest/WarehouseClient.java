package com.smalaca.warehouse.client.rest;

import java.util.List;

public interface WarehouseClient {
    List<Item> findItems(String search);
}
