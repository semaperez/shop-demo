package com.shop.demo.adapters.services.price;

import com.shop.demo.adapters.db.repository.JpaBrandRepository;
import com.shop.demo.adapters.db.repository.JpaPriceRepository;
import com.shop.demo.adapters.services.price.mapper.PriceEntityMapper;
import com.shop.demo.domain.model.Price;
import com.shop.demo.ports.outbound.services.price.PricePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricePort {
    private final JpaPriceRepository jpaPriceRepository;
    private final JpaBrandRepository jpaBrandRepository;
    private final PriceEntityMapper priceEntityMapper;
    @Override
    public List<Price> getPricesList(LocalDateTime startDate, Integer productId, Integer brandId) {
        return jpaPriceRepository.findByStartDateGreaterThanEqualAndProductIdAndBrandId(startDate, productId, brandId)
                .stream()
                .map(priceEntityMapper::toDomain)
                .toList();
    }
    @Override
    public List<Price> getPricesList() {
        return jpaPriceRepository.findAll()
                .stream()
                .map(priceEntityMapper::toDomain)
                .toList();
    }
}