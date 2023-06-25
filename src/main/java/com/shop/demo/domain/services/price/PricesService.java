package com.shop.demo.domain.services.price;

import com.shop.demo.domain.model.Price;
import com.shop.demo.ports.inbound.price.PriceUseCases;
import com.shop.demo.ports.outbound.services.price.PricePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PricesService implements PriceUseCases {
    private final PricePort pricePort;
    @Override
    public Price getPrice(LocalDateTime rangeDate, Integer productId, Integer brandId) {
        return pricePort.getPrice(rangeDate, productId, brandId);
    }
}
