package com.bala.spring.app.rest.controller;

import com.bala.spring.app.rest.URL;
import com.bala.spring.app.rest.dto.BaseResponse;
import com.bala.spring.app.rest.dto.ProductDTO;
import com.bala.spring.app.rest.dto.ProductRequest;
import com.bala.spring.app.rest.dto.ProductResponse;
import com.bala.spring.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URL.SECURED_PRD_URL)
public class ProductController extends BaseController  {

    @Autowired
    ProductService productService;

    @PostMapping("/getproduct")
    public ResponseEntity<BaseResponse> getProduct(
            @RequestBody ProductRequest request
    ) {

        String email = request.getEmail();
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Email is required");
        }

        ProductResponse productResponse= productService.getProduct(request);
        return ResponseEntity.ok(productResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> updateProduct(
            @RequestBody ProductRequest request
    ) {

        ProductResponse productResponse= productService.updateProduct(request);

        return ResponseEntity.ok(productResponse);

    }

    @PostMapping("/insert")
    public ResponseEntity insertProduct(
            @RequestBody ProductRequest request
    ) {

        ProductDTO productDTO = productService.insertProduct(request);
        return ResponseEntity.ok(productDTO);

    }


}
