package com.shop.demo.adapters.api.price.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@RequiredArgsConstructor
public class BrandDto {
    Integer id;
    String description;

}
