package com.shop.demo.adapters.db.repository;

import com.shop.demo.adapters.db.entity.PriceEntity;
import com.shop.demo.adapters.db.entity.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, PriceId> {
    Optional<List<PriceEntity>> findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandId
            (LocalDateTime startDate, LocalDateTime endDate, Integer productId, Integer brandId);
}
