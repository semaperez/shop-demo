package com.shop.demo.adapters.api.price.controller;

import com.shop.demo.adapters.api.price.dto.PriceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Prices managing")
@RequestMapping(value = "shop/prices")
public interface PricesApi {
    @Operation(summary = "This operation returned the list prices by params ")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prices list returned"),
            @ApiResponse(responseCode = "400", description = "Bad request param")
    })
    ResponseEntity<List<PriceDto>> getPricesList(@RequestParam("startDate") @Valid LocalDateTime startDate,
                                                 @RequestParam("productId") @Valid Integer productId,
                                                 @RequestParam("brandId") @Valid Integer brandId);

}
