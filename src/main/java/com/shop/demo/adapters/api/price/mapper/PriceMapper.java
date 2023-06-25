package com.shop.demo.adapters.api.price.mapper;

import com.shop.demo.adapters.api.price.dto.PriceDto;
import com.shop.demo.domain.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BrandMapper.class)
public interface PriceMapper {
    PriceDto toDto(Price price);
}
