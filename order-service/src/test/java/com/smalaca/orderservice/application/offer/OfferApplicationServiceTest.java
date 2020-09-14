package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.clock.Clock;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseRestClient;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseServiceContract;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseServiceScenario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Month;
import java.util.List;
import java.util.stream.Stream;

import static com.smalaca.orderservice.application.offer.OfferItemDtoExpectation.Builder.item;
import static com.smalaca.orderservice.application.offer.OfferItemsDtoAssertion.assertThat;
import static org.mockito.Mockito.mock;

class OfferApplicationServiceTest {
    private final WarehouseServiceContract contract = new WarehouseServiceContract();
    private final WarehouseRestClient warehouseRestClient = mock(WarehouseRestClient.class);
    private final Clock clock = mock(Clock.class);
    private final Given given = new Given(warehouseRestClient, clock);

    private final OfferApplicationService offerApplicationService = new OfferApplicationServiceFactory().create(warehouseRestClient, clock);

    @Test
    void shouldReturnNothingWhenNoItemsFound() {
        WarehouseServiceScenario scenario = contract.notExistingItems();
        given.foundItemsFor(scenario);

        List<OfferItemDto> actual = offerApplicationService.find(scenario.searchCriteria());

        assertThat(actual).hasNoItems();
    }

    @ParameterizedTest
    @MethodSource("discounts")
    void shouldReturnFoundItems(Month month, double expectedPrice1, double expectedPrice2) {
        WarehouseServiceScenario scenario = contract.existingItems();
        given
                .foundItemsFor(scenario)
                .currentMonth(month);

        List<OfferItemDto> actual = offerApplicationService.find(scenario.searchCriteria());

        assertThat(actual)
                .hasItems(2)
                .has(item()
                        .withId(2)
                        .withName("Clean Code: A Handbook of Agile Software Craftsmanship")
                        .withPrice(expectedPrice1, "PLN"))
                .has(item()
                        .withId(6)
                        .withName("The Clean Coder: A Code of Conduct for Professional Programmers")
                        .withPrice(expectedPrice2, "PLN"));
    }

    private static Stream<Arguments> discounts() {
        return Stream.of(
                Arguments.of(Month.JANUARY, 110, 70),
                Arguments.of(Month.FEBRUARY, 110, 70),
                Arguments.of(Month.MARCH, 93.5, 59.5),
                Arguments.of(Month.APRIL, 93.5, 59.5),
                Arguments.of(Month.MAY, 110, 70),
                Arguments.of(Month.JUNE, 110, 70),
                Arguments.of(Month.JULY, 110, 70),
                Arguments.of(Month.AUGUST, 110, 70),
                Arguments.of(Month.SEPTEMBER, 77, 49),
                Arguments.of(Month.OCTOBER, 77, 49),
                Arguments.of(Month.NOVEMBER, 110, 70),
                Arguments.of(Month.DECEMBER, 99, 63)
        );
    }
}