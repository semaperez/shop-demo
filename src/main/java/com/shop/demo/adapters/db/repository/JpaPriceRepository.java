package com.shop.demo.adapters.db.repository;

import com.shop.demo.adapters.db.entity.PriceEntity;
import com.shop.demo.adapters.db.entity.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, PriceId> {
    List<PriceEntity> findByStartDateGreaterThanEqualAndProductIdAndBrandId(LocalDateTime startDate, Integer productId, Integer brandId);
}
