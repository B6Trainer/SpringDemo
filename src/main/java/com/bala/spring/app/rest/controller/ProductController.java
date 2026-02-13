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
    public ResponseEntity<BaseResponse> getProduct(
            @RequestBody ProductRequest request
    ) {

        //request.setRequestAction(RA_GET_PRODUCT);
        ProductResponse productResponse= ProductResponse.builder()
                .product_id(15)
                .productName("TV")
                .build();

        return ResponseEntity.ok(productResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> updateProduct(
            @RequestBody ProductRequest request
    ) {

        ProductResponse productResponse= ProductResponse.builder()
                .product_id(12)
                .productName(request.getProductName())
                .quantity(request.getQuantity())
                .cost(request.getQuantity() * 20.0)
                .build();
        return ResponseEntity.ok(productResponse);
        //return ResponseEntity.ok(processNewRequest(request));
    }


}
