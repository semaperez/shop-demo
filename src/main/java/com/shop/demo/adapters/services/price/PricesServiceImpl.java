package com.shop.demo.adapters.services.price;

import com.shop.demo.adapters.db.entity.PriceEntity;
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
                .flatMap(list -> list.stream()
                        .max(Comparator.comparingInt(PriceEntity::getPriority))
                        .map(priceEntityMapper::toDomain))
                .orElse(null);
    }
}
