package com.smalaca.warehouse.infrastructure.persistence.inmemory;

import com.smalaca.warehouse.query.item.ItemDto;
import com.smalaca.warehouse.query.item.QueryItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.smalaca.warehouse.query.item.Currency.PLN;
import static com.smalaca.warehouse.query.item.Price.price;
import static java.util.stream.Collectors.toList;

@Repository
class InMemoryQueryItemRepository implements QueryItemRepository {
    private final List<ItemDto> items = new ArrayList<>();

    InMemoryQueryItemRepository() {
        items.add(new ItemDto(1, "Working Effectively with Legacy Code", price(100, PLN)));
        items.add(new ItemDto(2, "Clean Code: A Handbook of Agile Software Craftsmanship", price(110, PLN)));
        items.add(new ItemDto(3, "Refactoring: Improving the Design of Existing Code", price(200, PLN)));
        items.add(new ItemDto(4, "The Pragmatic Programmer: Your Journey To Mastery", price(120, PLN)));
        items.add(new ItemDto(5, "Clean Architecture: A Craftsman's Guide to Software Structure and Design", price(80, PLN)));
        items.add(new ItemDto(6, "The Clean Coder: A Code of Conduct for Professional Programmers", price(70, PLN)));
        items.add(new ItemDto(7, "Code Complete: A Practical Handbook of Software Construction", price(110, PLN)));
        items.add(new ItemDto(8, "Test Driven Development: By Example", price(100, PLN)));
        items.add(new ItemDto(9, "Designing Data-Intensive Applications: The Big Ideas Behind Reliable", price(80, PLN)));
        items.add(new ItemDto(10, "Building Microservices: Designing Fine-Grained Systems", price(120, PLN)));
        items.add(new ItemDto(11, "Release It!: Design and Deploy Production-Ready Software", price(80, PLN)));
        items.add(new ItemDto(12, "Domain-Driven Design: Tackling Complexity in the Heart of Software ", price(160, PLN)));
        items.add(new ItemDto(13, "Implementing Domain-Driven Design", price(150, PLN)));
    }

    @Override
    public List<ItemDto> findAllThatSatisfies(String search) {
        return items.stream()
                .filter(itemDto -> itemDto.doesNameContain(search))
                .collect(toList());
    }
}
