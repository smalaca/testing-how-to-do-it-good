package com.smalaca.orderservice.application.offer;

import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseRestClient;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseServiceContract;
import com.smalaca.orderservice.infrastructure.warehouse.rest.WarehouseServiceScenario;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.smalaca.orderservice.application.offer.OfferItemDtoExpectation.Builder.item;
import static com.smalaca.orderservice.application.offer.OfferItemsDtoAssertion.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class OfferApplicationServiceTest {
    private final WarehouseServiceContract contract = new WarehouseServiceContract();
    private final WarehouseRestClient warehouseRestClient = mock(WarehouseRestClient.class);

    private final OfferApplicationService offerApplicationService = new OfferApplicationServiceFactory().create(warehouseRestClient);

    @Test
    void shouldReturnNothingWhenNoItemsFound() {
        WarehouseServiceScenario scenario = contract.notExistingItems();
        given(warehouseRestClient.findItems(scenario.searchCriteria())).willReturn(scenario.expectedItems());

        List<OfferItemDto> actual = offerApplicationService.find(scenario.searchCriteria());

        assertThat(actual).hasNoItems();
    }

    @Test
    void shouldReturnFoundItems() {
        WarehouseServiceScenario scenario = contract.existingItems();
        given(warehouseRestClient.findItems(scenario.searchCriteria())).willReturn(scenario.expectedItems());

        List<OfferItemDto> actual = offerApplicationService.find(scenario.searchCriteria());

        assertThat(actual)
                .hasItems(2)
                .has(item()
                        .withId(2)
                        .withName("Clean Code: A Handbook of Agile Software Craftsmanship")
                        .withPrice(110, "PLN"))
                .has(item()
                        .withId(6)
                        .withName("The Clean Coder: A Code of Conduct for Professional Programmers")
                        .withPrice(70, "PLN"));
    }
}