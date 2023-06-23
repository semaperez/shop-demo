package com.shop.demo.adapters.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BRANDS")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class BrandEntity {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRIPTION", length = 25)
    private String description;
}
