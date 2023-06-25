package com.shop.demo.adapters.api.price.controller;

import com.shop.demo.adapters.api.price.dto.PriceDto;
import com.shop.demo.adapters.api.price.mapper.PriceMapper;
import com.shop.demo.ports.inbound.price.PriceUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PricesController implements PricesApi{
    private final PriceUseCases priceUseCases;
    private final PriceMapper priceMapper;
    @Override
    public ResponseEntity<List<PriceDto>> getPricesList(LocalDateTime startDate, Integer productId, Integer brandId) {
        return ResponseEntity.ok(priceUseCases.getPricesList(startDate, productId, brandId)
                .stream()
                .map(priceMapper::toDto)
                .toList());
    }
}
