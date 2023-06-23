package com.shop.demo.adapters.api.price.mapper;

import com.shop.demo.adapters.api.price.dto.BrandDto;
import com.shop.demo.domain.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandDto toDto(Brand brand);
    Brand toDomain(BrandDto dto);
}
