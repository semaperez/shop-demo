package com.shop.demo.adapters.api.price.controller;

import com.shop.demo.adapters.api.price.dto.PriceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Tag(name = "Prices managing")
@RequestMapping(value = "prices")
public interface PricesApi {
    @Operation(summary = "Returns the price matching the specified parameters")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Price returned"),
            @ApiResponse(responseCode = "204", description = "No price found"),
            @ApiResponse(responseCode = "400", description = "Bad request param")
    })
    ResponseEntity<PriceDto> getPrice(@RequestParam("startDate") LocalDateTime rangeDate,
                                                 @RequestParam("productId") Integer productId,
                                                 @RequestParam("brandId") Integer brandId);

}
