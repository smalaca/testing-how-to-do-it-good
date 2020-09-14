package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.clock.Clock;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseRestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferApplicationServiceFactory {
    @Bean
    public OfferApplicationService create(WarehouseRestClient warehouseRestClient, Clock clock) {
        return new OfferApplicationService(warehouseRestClient, clock);
    }
}
