package com.shop.demo.adapters.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@IdClass(PriceId.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class PriceEntity {
    @Id
    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "CURR", length = 3)
    private String currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID")
    private BrandEntity brand;
}
