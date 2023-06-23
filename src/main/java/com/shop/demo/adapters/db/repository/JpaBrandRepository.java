package com.shop.demo.adapters.db.repository;

import com.shop.demo.adapters.db.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBrandRepository extends JpaRepository<BrandEntity, Integer> {
}
