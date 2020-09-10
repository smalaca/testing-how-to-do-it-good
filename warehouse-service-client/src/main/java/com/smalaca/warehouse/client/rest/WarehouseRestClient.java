package com.smalaca.warehouse.client.rest;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static java.util.Arrays.asList;

class WarehouseRestClient implements WarehouseClient {
    private final RestTemplate restTemplate;
    private final String url;

    WarehouseRestClient(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public List<Item> findItems(String search) {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl(url + "/item")
                .queryParam("search", search)
                .build().toUri();

        Item[] result = restTemplate.getForObject(uri, Item[].class);

        return asList(result);
    }
}
