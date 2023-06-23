package com.shop.demo.adapters.api.price.mapper;

import com.shop.demo.adapters.api.price.dto.PriceDto;
import com.shop.demo.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", uses = BrandMapper.class)
public interface PriceMapper {
    PriceDto toDto(Price price);
    @Mapping(source = "startDate",target = "startDate")
    @Mapping(source = "productId",target = "productId")
    @Mapping(source = "brandId",target = "brand.id")
    Price toDomain(LocalDateTime startDate, Integer productId, Integer brandId);
}
