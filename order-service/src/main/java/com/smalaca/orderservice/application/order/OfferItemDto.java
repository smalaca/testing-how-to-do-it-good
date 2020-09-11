package com.smalaca.orderservice.application.order;

public class OfferItemDto {
    private final int id;
    private final String name;
    private final OfferItemPriceDto price;

    public OfferItemDto(int id, String name, OfferItemPriceDto price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public OfferItemPriceDto getPrice() {
        return price;
    }
}
