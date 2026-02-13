package com.bala.spring.app.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class ProductResponse extends BaseResponse implements ResponseBody {


  @JsonProperty("product_id")
  private int product_id;


  @JsonProperty("product_name")
  private String product_name;



}
