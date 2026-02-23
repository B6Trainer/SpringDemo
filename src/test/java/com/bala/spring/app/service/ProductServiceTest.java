package com.bala.spring.app.service;

import com.bala.spring.app.dao.entity.ProductEntity;
import com.bala.spring.app.dao.repo.ProductRepository;
import com.bala.spring.app.rest.dto.ProductDTO;
import com.bala.spring.app.rest.dto.ProductRequest;
import com.bala.spring.app.rest.dto.ProductResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    void insertProduct_success() {
        ProductRequest req = new ProductRequest();
        req.setProductId("PRD-1");
        req.setProductName("Widget");
        req.setAmount(new BigDecimal("9.99"));
        req.setQuantity(5);
        req.setType("Gadget");
        req.setCategory("Cat");
        req.setDescription("Desc");

        ProductEntity saved = ProductEntity.builder()
                .id(1)
                .productId(req.getProductId())
                .productName(req.getProductName())
                .amount(req.getAmount())
                .quantity(req.getQuantity())
                .type(req.getType())
                .category(req.getCategory())
                .description(req.getDescription())
                .build();

        when(productRepository.save(any(ProductEntity.class))).thenReturn(saved);

        ProductDTO dto = productService.insertProduct(req);

        assertNotNull(dto);
        assertEquals(saved.getId(), dto.getId());
        assertEquals(saved.getProductId(), dto.getProductId());
        assertEquals(saved.getProductName(), dto.getProductName());
        assertEquals(saved.getAmount(), dto.getAmount());
        assertEquals(saved.getQuantity(), dto.getQuantity());

        verify(productRepository).save(any(ProductEntity.class));
    }

    @Test
    void updateProduct_success() {
        ProductRequest req = new ProductRequest();
        req.setProductId("PRD-2");
        req.setQuantity(42);

        ProductEntity existing = ProductEntity.builder()
                .id(2)
                .productId("PRD-2")
                .productName("Gizmo")
                .amount(new BigDecimal("19.99"))
                .quantity(10)
                .build();

        when(productRepository.findByProductId("PRD-2")).thenReturn(Optional.of(existing));
        when(productRepository.save(any(ProductEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ProductResponse resp = productService.updateProduct(req);

        assertNotNull(resp);
        assertEquals(existing.getProductId(), resp.getProduct_id());
        assertEquals(existing.getProductName(), resp.getProductName());
        assertEquals(existing.getAmount(), resp.getCost());
        assertEquals(42, resp.getQuantity());

        verify(productRepository).findByProductId("PRD-2");
        verify(productRepository).save(any(ProductEntity.class));
    }

    @Test
    void updateProduct_notFound() {
        ProductRequest req = new ProductRequest();
        req.setProductId("NOT-FOUND");
        req.setQuantity(1);

        when(productRepository.findByProductId("NOT-FOUND")).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> productService.updateProduct(req));

        verify(productRepository).findByProductId("NOT-FOUND");
        verify(productRepository, never()).save(any());
    }

    @Test
    void getProduct_present() {
        ProductRequest req = new ProductRequest();
        req.setProductId("PRD-3");

        ProductEntity existing = ProductEntity.builder()
                .id(3)
                .productId("PRD-3")
                .productName("Thing")
                .amount(new BigDecimal("5.50"))
                .quantity(7)
                .build();

        when(productRepository.findByProductId("PRD-3")).thenReturn(Optional.of(existing));

        ProductResponse resp = productService.getProduct(req);

        assertNotNull(resp);
        assertEquals(existing.getProductId(), resp.getProduct_id());
        assertEquals(existing.getProductName(), resp.getProductName());
        assertEquals(existing.getAmount(), resp.getCost());

        verify(productRepository).findByProductId("PRD-3");
    }

    @Test
    void getProduct_empty() {
        ProductRequest req = new ProductRequest();
        req.setProductId("UNKNOWN");

        when(productRepository.findByProductId("UNKNOWN")).thenReturn(Optional.empty());

        ProductResponse resp = productService.getProduct(req);

        assertNotNull(resp);
        assertNull(resp.getProduct_id());
        assertNull(resp.getCost());

        verify(productRepository).findByProductId("UNKNOWN");
    }
}
