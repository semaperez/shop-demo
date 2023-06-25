package com.shop.demo.ports.inbound.price;

import com.shop.demo.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceUseCases {
    Price getPrice(LocalDateTime rangeDate, Integer productId, Integer brandId);
}
