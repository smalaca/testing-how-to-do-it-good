package com.smalaca.orderservice.infrastructure.clock.localdate;

import com.smalaca.orderservice.clock.Clock;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
class RealtimeClock implements Clock {
    @Override
    public LocalDate now() {
        return LocalDate.now();
    }
}
