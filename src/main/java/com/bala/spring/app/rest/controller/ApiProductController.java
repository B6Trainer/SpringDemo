package com.bala.spring.app.rest.controller;

import com.bala.spring.app.dao.entity.ProductEntity;
import com.bala.spring.app.dao.repo.ProductRepository;
import com.bala.spring.app.rest.URL;
import com.bala.spring.app.rest.dto.BaseResponse;
import com.bala.spring.app.rest.dto.ProductRequest;
import com.bala.spring.app.rest.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(URL.SECURED_PRD_URL_API)
public class ApiProductController extends BaseController  {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/getproduct")
    public ResponseEntity<BaseResponse> getProduct(
            @RequestBody ProductRequest request
    ) {

        String apiKey = request.getApiKey();
        if(apiKey == null || apiKey.isEmpty()){
            throw new IllegalArgumentException("API Key is required");
        }

        String productId = request.getProductId();
        Optional<ProductEntity> productEntityOptional = productRepository.findByProductId(productId);//"PRD-123"


        ProductResponse productResponse= ProductResponse.builder().build();
        productEntityOptional.ifPresent(entity -> {
            productResponse.setProduct_id(entity.getProductId());
            productResponse.setProductName(entity.getProductName());
            productResponse.setCost(entity.getAmount());
        });

        return ResponseEntity.ok(productResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> updateProduct(
            @RequestBody ProductRequest request
    ) {

        ProductResponse productResponse= ProductResponse.builder()
                .product_id("12")
                .productName(request.getProductName())
                .quantity(request.getQuantity())
                //.cost(request.getQuantity() )
                .build();
        return ResponseEntity.ok(productResponse);
        //return ResponseEntity.ok(processNewRequest(request));
    }

    @PostMapping("/insert")
    public ResponseEntity insertProduct(
            @RequestBody ProductRequest request
    ) {


        ProductEntity entity = ProductEntity.builder()
                .productId("PRD-123")
                .productName(request.getProductName())
                .amount(request.getAmount())
                .type(request.getType())
                .category(request.getCategory())
                .description(request.getDescription())
                .build();


        productRepository.save(entity);

        return ResponseEntity.ok(entity);
        //return ResponseEntity.ok(processNewRequest(request));
    }


}
