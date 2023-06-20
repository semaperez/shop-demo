package com.shop.demo.adapters.db.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@IdClass(PriceId.class)
@Data
public class Price {
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
    private Brand brand;
}
