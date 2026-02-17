package com.bala.spring.app.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor

public class ProductRequest extends BaseRequest {

    @JsonProperty("email")
    private String email;

    @JsonProperty("api_key")
    private String apiKey;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("quantity")
    private int quantity;


    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("category")
    private String category;
    @JsonProperty("type")
    private String type;
    @JsonProperty("description")
    private String description;
    @JsonProperty("amount")
    private BigDecimal amount;

}
