package com.shop.demo.ports.inbound.price;

import com.shop.demo.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceUseCases {
    List<Price> getPricesList(LocalDateTime startDate, Integer productId, Integer brandId);
    List<Price> getPricesList();
}
