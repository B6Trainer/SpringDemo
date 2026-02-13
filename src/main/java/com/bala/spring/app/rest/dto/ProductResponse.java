package com.bala.spring.app.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

public class ProductResponse implements ResponseBody {


  @JsonProperty("product_id")
  private String txnId;




}
