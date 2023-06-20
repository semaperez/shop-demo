package com.shop.demo.adapters.db.entity;

import lombok.Data;
import java.io.Serializable;
@Data
public class PriceId implements Serializable {
    private Integer priceList;
    private Integer productId;

 }