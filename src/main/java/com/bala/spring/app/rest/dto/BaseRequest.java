package com.bala.spring.app.rest.dto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
public class BaseRequest {

    private String requestAction;

    private HttpServletRequest httpServletRequest;

    private HttpServletResponse httpServletResponse;


}