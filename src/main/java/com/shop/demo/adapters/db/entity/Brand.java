package com.shop.demo.adapters.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "BRANDS")
public class Brand {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRIPTION", length = 25)
    private String description;
}
