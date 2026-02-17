package com.bala.spring.app.rest;

public interface URL {

    String API_CLIENT_PREFIX = "api";
    String THIN_CLIENT_PREFIX = "tc";
    String TC_VERSION = "v1";
    String BASE_URL = "/"+THIN_CLIENT_PREFIX+"/"+ TC_VERSION;
    String BASE_API_URL = "/"+API_CLIENT_PREFIX+"/"+ TC_VERSION;

    String SECURED_PRD_URL = BASE_URL+"/product";
    String SECURED_PAYMENT_URL = BASE_URL+"/payment";


    String SECURED_PRD_URL_API = BASE_API_URL+"/product";
}
