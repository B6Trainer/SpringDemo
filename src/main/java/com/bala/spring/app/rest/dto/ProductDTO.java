package com.bala.spring.app.rest.dto;


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

public class ProductDTO {

  private Integer id;
  private String productId;
  private String productName;

  private String category;
  private String type;
  private String description;
  private String status;
  private BigDecimal amount;
  private Integer quantity;

}
