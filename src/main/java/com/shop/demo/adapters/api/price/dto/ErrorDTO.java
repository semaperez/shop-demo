package com.shop.demo.adapters.api.price.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorDTO {
    Integer error;
    String responseType;
    String errorMessage;
    LocalDateTime dateTime;
}
