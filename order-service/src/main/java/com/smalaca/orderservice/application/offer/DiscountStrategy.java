package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.clock.Clock;

import java.time.LocalDate;

class DiscountStrategy {
    private final Clock clock;

    DiscountStrategy(Clock clock) {
        this.clock = clock;
    }

    double withDiscount(int amount) {
        LocalDate now = clock.now();

        switch (now.getMonth()) {
            case MARCH:
            case APRIL:
                return amount * 0.85;

            case SEPTEMBER:
            case OCTOBER:
                return amount * 0.7;

            case DECEMBER:
                return amount * 0.9;
        }

        return amount;
    }
}