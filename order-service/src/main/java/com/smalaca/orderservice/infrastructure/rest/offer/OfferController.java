package com.smalaca.orderservice.infrastructure.rest.offer;

import com.smalaca.orderservice.application.offer.OfferApplicationService;
import com.smalaca.orderservice.application.offer.OfferItemDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offer")
public class OfferController {
    private final OfferApplicationService offerApplicationService;

    public OfferController(OfferApplicationService offerApplicationService) {
        this.offerApplicationService = offerApplicationService;
    }

    @GetMapping
    public List<OfferItemDto> find(@RequestParam String search) {
        return offerApplicationService.find(search);
    }
}
