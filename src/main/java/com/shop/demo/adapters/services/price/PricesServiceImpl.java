package com.shop.demo.adapters.services.price;

import com.shop.demo.adapters.db.repository.JpaPriceRepository;
import com.shop.demo.adapters.services.price.mapper.PriceEntityMapper;
import com.shop.demo.domain.model.Price;
import com.shop.demo.ports.outbound.services.price.PricePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricePort {
    private final JpaPriceRepository jpaPriceRepository;
    private final PriceEntityMapper priceEntityMapper;
    @Override
    public Price getPrice(LocalDateTime rangeDate, Integer productId, Integer brandId) {
        return jpaPriceRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandId(rangeDate, rangeDate, productId,
                        brandId)
                .map(list -> list.stream()
                        .map(priceEntityMapper::toDomain)
                        .sorted(Comparator.comparingInt(Price::getPriority).reversed())
                        .findFirst()
                        .orElse(null))
                .orElse(null);
    }
}
