package com.smalaca.orderservice.infrastructure.clock.localdate;

import com.smalaca.orderservice.clock.Clock;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class RealtimeClockTest {
    private final Clock clock = new RealtimeClock();

    @Test
    void shouldReturnLocalDate() {
        LocalDate actual = clock.now();

        assertThat(actual).isInstanceOf(LocalDate.class);
    }
}