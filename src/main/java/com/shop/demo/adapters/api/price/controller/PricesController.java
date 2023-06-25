package com.shop.demo.adapters.api.price.controller;

import com.shop.demo.adapters.api.price.dto.PriceDto;
import com.shop.demo.adapters.api.price.mapper.PriceMapper;
import com.shop.demo.ports.inbound.price.PriceUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class PricesController implements PricesApi{
    private final PriceUseCases priceUseCases;
    private final PriceMapper priceMapper;
    @Override
    public ResponseEntity<PriceDto> getPrice(LocalDateTime rangeDate, Integer productId, Integer brandId) {
        PriceDto priceDto = priceMapper.toDto(priceUseCases.getPrice(rangeDate, productId, brandId));
        if (priceDto == null){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(priceDto);
        }
    }
}
