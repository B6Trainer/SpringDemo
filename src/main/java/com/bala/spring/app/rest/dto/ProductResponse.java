package com.bala.spring.app.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class ProductResponse extends BaseResponse implements ResponseBody {


  @JsonProperty("product_id")
  private String product_id;

  @JsonProperty("product_name")
  private String productName;

  @JsonProperty("quantity")
  private int quantity;

  @JsonProperty("cost")
  private BigDecimal cost;


}
