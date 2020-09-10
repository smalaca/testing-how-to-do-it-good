package com.smalaca.orderservice.infrastructure.warehouse.rest;

import com.smalaca.warehouse.client.rest.WarehouseClient;
import com.smalaca.warehouse.client.rest.WarehouseRestClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WarehouseServiceConfiguration {
    @Bean
    public WarehouseClient warehouseClient(@Value("${warehouse.rest.url}") String url) {
        return new WarehouseRestClientFactory().create(new RestTemplate(), url);
    }
}
