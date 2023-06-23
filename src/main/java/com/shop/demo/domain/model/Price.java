package com.shop.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    Integer priceList;
    Integer productId;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Integer priority;
    BigDecimal totalPrice;
    String currency;
    Brand brand;

}
