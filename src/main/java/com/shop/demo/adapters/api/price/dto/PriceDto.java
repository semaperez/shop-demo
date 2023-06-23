package com.shop.demo.adapters.api.price.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Value
@Builder
@Jacksonized
@RequiredArgsConstructor
public class PriceDto {
    Integer priceList;
    Integer productId;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Integer priority;
    BigDecimal totalPrice;
    String currency;
    BrandDto brand;

}
