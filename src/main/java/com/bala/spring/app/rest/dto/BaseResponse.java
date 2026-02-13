package com.bala.spring.app.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
@ToString

@SuperBuilder
public class BaseResponse {

    private int responseCode=0;

    private String responseStatus="failed";

    private String responseMessage="Failed to process the request";

    private ResponseBody respObject=null;

}