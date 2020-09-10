package com.smalaca.warehouse.client.rest;

import org.springframework.web.client.RestTemplate;

public class WarehouseRestClientFactory {
    public WarehouseClient create(RestTemplate restTemplate, String url) {
        return new WarehouseRestClient(restTemplate, url);
    }
}
