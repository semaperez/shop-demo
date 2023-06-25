package com.shop.demo.ports.outbound.services.price;

import com.shop.demo.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PricePort {
    List<Price> getPricesList(LocalDateTime startDate, Integer productId, Integer brandId);
}
