package com.smalaca.warehouse.query.item;

public class ItemDto {
    private final int id;
    private final String name;
    private final Price price;

    public ItemDto(int id, String name, Price price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public boolean doesNameContain(String search) {
        return name.toLowerCase().contains(search.toLowerCase());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}
