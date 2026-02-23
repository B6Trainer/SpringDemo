package com.bala.spring.app.dao.repo;

import com.bala.spring.app.dao.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private ProductRepository repository;

    @Test
    void findByProductId_returnsEntity() {
        ProductEntity p = ProductEntity.builder()
                .productId("TST-1")
                .productName("TestProd")
                .amount(new BigDecimal("1.00"))
                .quantity(3)
                .build();

        em.persistAndFlush(p);

        Optional<ProductEntity> found = repository.findByProductId("TST-1");

        assertThat(found).isPresent();
        assertThat(found.get().getProductName()).isEqualTo("TestProd");
    }

    @Test
    void findLatest_returnsOrderedList() {
        ProductEntity a = ProductEntity.builder().productId("L1").productName("A").build();
        ProductEntity b = ProductEntity.builder().productId("L2").productName("B").build();

        em.persist(a);
        em.persist(b);
        em.flush();

        List<ProductEntity> latest = repository.findLatest();

        assertThat(latest).isNotEmpty();
        // latest should be ordered by id DESC so first element should be the last persisted (b)
        assertThat(latest.get(0).getProductId()).isEqualTo("L2");
    }
}
