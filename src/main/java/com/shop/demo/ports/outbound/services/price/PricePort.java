package com.shop.demo.ports.outbound.services.price;

import com.shop.demo.domain.model.Price;

import java.time.LocalDateTime;

public interface PricePort {
    Price getPrice(LocalDateTime rangeDate, Integer productId, Integer brandId);
}
