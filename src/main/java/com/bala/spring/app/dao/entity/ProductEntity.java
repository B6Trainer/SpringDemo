package com.bala.spring.app.dao.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dm_product")
public class ProductEntity {

  @Id
  @GeneratedValue
  private Integer id;
  private String productId;

  private String category;
  private String type;
  private String description;

  private String status;

  @Column(columnDefinition = "DECIMAL(19, 4) DEFAULT 0.0")
  private BigDecimal amount;



}
