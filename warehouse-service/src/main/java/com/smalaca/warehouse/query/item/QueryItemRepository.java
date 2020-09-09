package com.smalaca.warehouse.query.item;

import java.util.List;

public interface QueryItemRepository {
    List<ItemDto> findAllThatSatisfies(String search);
}
