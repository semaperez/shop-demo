package com.shop.demo.adapters.services.price.mapper;

import com.shop.demo.adapters.db.entity.PriceEntity;
import com.shop.demo.domain.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BrandEntityMapper.class)
public interface PriceEntityMapper {
    Price toDomain(PriceEntity entity);
}
