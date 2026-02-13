package com.bala.spring.app.rest.controller;

import com.bala.spring.app.rest.URL;
import com.bala.spring.app.rest.dto.BaseResponse;
import com.bala.spring.app.rest.dto.ProductRequest;
import com.bala.spring.app.rest.dto.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URL.SECURED_PRD_URL)
public class ProductController extends BaseController  {

    @PostMapping("/getproduct")
    public ResponseEntity<BaseResponse> crtLicense(
            @RequestBody ProductRequest request
    ) {

        //request.setRequestAction(RA_GET_PRODUCT);
        ProductResponse productResponse= ProductResponse.builder()
                .product_id(12)
                .product_name("Laptop")
                .build();

        return ResponseEntity.ok(productResponse);
    }

    @PostMapping("/updateproduct")
    public ResponseEntity<BaseResponse> updateProduct(
            @RequestBody ProductRequest request
    ) {

        //request.setRequestAction(RA_GET_PRODUCT);
        ProductResponse productResponse= ProductResponse.builder()
                .product_id(12)
                .product_name("Laptop")
                .build();

        return ResponseEntity.ok(processNewRequest(request));
    }


}
