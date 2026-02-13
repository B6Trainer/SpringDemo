package com.bala.spring.app.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@Getter
public class ProductRequest extends BaseRequest {

    @JsonProperty("email")
    private String email;





}
