package com.smalaca.orderservice.infrastructure.rest.offer;

import com.smalaca.orderservice.application.offer.OfferApplicationService;
import com.smalaca.orderservice.application.offer.OfferItemDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class OfferControllerTest {
    private static final String SOME_SEARCH = "I'm looking for something";
    private static final List<OfferItemDto> SOME_OFFERS = asList(mock(OfferItemDto.class), mock(OfferItemDto.class));

    private final OfferApplicationService service = mock(OfferApplicationService.class);
    private final OfferController controller = new OfferController(service);

    @Test
    void shouldFindAllItems() {
        given(service.find(SOME_SEARCH)).willReturn(SOME_OFFERS);

        List<OfferItemDto> actual = controller.find(SOME_SEARCH);

        assertThat(actual).isEqualTo(SOME_OFFERS);
    }
}