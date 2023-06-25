package com.shop.demo.domain.services.price;

import com.shop.demo.domain.model.Price;
import com.shop.demo.ports.outbound.services.price.PricePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesServiceTest {
    @InjectMocks
    private PricesService sut;
    @Mock
    private PricePort pricePort;

    @Test
    void given_startDateAndProductIdAndBrandId_when_getPrice_listIsReturned(){
        when(pricePort.getPrice(any(),any(),any())).thenReturn(Price.builder().build());
        Price response = sut.getPrice(LocalDateTime.now(),1,2);
        assertNotNull(response);
    }

}