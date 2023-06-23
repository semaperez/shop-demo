package com.shop.demo.adapters.services.price.mapper;

import com.shop.demo.adapters.db.entity.BrandEntity;
import com.shop.demo.domain.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandEntityMapper {
    BrandEntity toEntity(Brand price);
    Brand toDomain(BrandEntity entity);
}
