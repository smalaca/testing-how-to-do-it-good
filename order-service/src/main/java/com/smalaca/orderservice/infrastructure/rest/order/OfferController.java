package com.smalaca.orderservice.infrastructure.rest.order;

import com.smalaca.orderservice.application.order.OfferItemDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/offer")
public class OfferController {
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
        return Collections.emptyList();
    }
}
