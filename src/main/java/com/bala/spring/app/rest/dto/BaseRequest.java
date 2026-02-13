package com.bala.spring.app.rest.dto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@NoArgsConstructor
public class BaseRequest {



    private HttpServletRequest httpServletRequest;

    private HttpServletResponse httpServletResponse;


}