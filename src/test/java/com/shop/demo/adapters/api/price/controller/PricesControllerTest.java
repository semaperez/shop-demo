package com.shop.demo.adapters.api.price.controller;

import com.shop.demo.adapters.api.price.dto.PriceDto;
import com.shop.demo.adapters.api.price.mapper.PriceMapper;
import com.shop.demo.domain.model.Price;
import com.shop.demo.ports.inbound.price.PriceUseCases;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PricesControllerTest {
    @InjectMocks
    private PricesController sut;
    @Mock
    private PriceUseCases priceUseCases;
    @Mock
    private PriceMapper priceMapper;

    @Test
    void given_startDateAndProductIdAndBrandId_when_getPrice_responseIsReturned(){
        PriceDto priceDto = PriceDto.builder().build();
        when(priceUseCases.getPrice(any(),any(), any())).thenReturn(Price.builder().build());
        when(priceMapper.toDto(any())).thenReturn(PriceDto.builder().build());
        ResponseEntity<PriceDto> response = sut.getPrice(LocalDateTime.now(),1,2);
        assertNotNull(response);
        assertEquals(priceDto, response.getBody());
    }


}