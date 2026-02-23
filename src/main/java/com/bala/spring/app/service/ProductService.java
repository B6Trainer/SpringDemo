package com.bala.spring.app.service;

import com.bala.spring.app.dao.entity.ProductEntity;
import com.bala.spring.app.dao.repo.ProductRepository;
import com.bala.spring.app.rest.dto.ProductDTO;
import com.bala.spring.app.rest.dto.ProductRequest;
import com.bala.spring.app.rest.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductDTO insertProduct(ProductRequest request) {

        ProductEntity entity = ProductEntity.builder()
                .productId(request.getProductId())
                .productName(request.getProductName())
                .amount(request.getAmount())
                .quantity(request.getQuantity())
                .type(request.getType())
                .category(request.getCategory())
                .description(request.getDescription())
                .build();


        ProductEntity savedEntity =productRepository.save(entity);

//        List<ProductEntity> entities = new ArrayList<>();
//        productRepository.saveAll(entities);

        ProductDTO productDTO = ProductDTO.builder()
                .id(savedEntity.getId())
                .productId(savedEntity.getProductId())
                .productName(savedEntity.getProductName())
                .amount(savedEntity.getAmount())
                .quantity(savedEntity.getQuantity())
                .type(savedEntity.getType())
                .category(savedEntity.getCategory())
                .description(savedEntity.getDescription())
                .build();

        return productDTO;
    }

    public ProductResponse updateProduct(ProductRequest request){
        String productId = request.getProductId();
        Optional<ProductEntity> productEntityOptional = productRepository.findByProductId(productId);//"PRD-123"

        if(productEntityOptional.isEmpty()){
            throw new IllegalArgumentException("Product not found for id: " + productId);
        }

        ProductEntity entity = productEntityOptional.get();
        entity.setQuantity(request.getQuantity());
        productRepository.save(entity);

        ProductResponse productResponse= ProductResponse.builder()
                .product_id(entity.getProductId())
                .productName(entity.getProductName())
                .cost(entity.getAmount())
                .quantity(entity.getQuantity())
                .build();

        return productResponse;
    }

    public ProductResponse getProduct(ProductRequest request){

        String productId = request.getProductId();
        Optional<ProductEntity> productEntityOptional = productRepository.findByProductId(productId);//"PRD-123"


        ProductResponse productResponse= ProductResponse.builder().build();
        productEntityOptional.ifPresent(entity -> {
            productResponse.setProduct_id(entity.getProductId());
            productResponse.setProductName(entity.getProductName());
            productResponse.setCost(entity.getAmount());
        });

        return productResponse;
    }
}
