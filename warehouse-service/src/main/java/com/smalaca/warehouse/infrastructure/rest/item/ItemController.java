package com.smalaca.warehouse.infrastructure.rest.item;

import com.smalaca.warehouse.query.item.ItemDto;
import com.smalaca.warehouse.query.item.QueryItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final QueryItemRepository repository;

    public ItemController(QueryItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> findAllThatSatisfies(@RequestParam String search) {
        List<ItemDto> result = repository.findAllThatSatisfies(search);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result);
    }
}
