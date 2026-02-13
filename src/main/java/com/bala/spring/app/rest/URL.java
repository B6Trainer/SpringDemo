package com.bala.spring.app.rest;

public interface URL {

    String THIN_CLIENT_PREFIX = "tc";
    String TC_VERSION = "v1";
    String BASE_URL = "/"+THIN_CLIENT_PREFIX+"/"+ TC_VERSION;

    String SECURED_PRD_URL = BASE_URL+"/prd";
}
