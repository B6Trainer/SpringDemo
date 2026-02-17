package com.bala.spring.app.dao.repo;


import com.bala.spring.app.dao.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

  // Select all  - irrespective status attribute
  List<ProductEntity> findAll();


  @Query("SELECT c FROM ProductEntity c ORDER BY c.id DESC")
  List<ProductEntity> findLatest();

  @Query("SELECT c FROM ProductEntity c WHERE c.productId = :productId")
  Optional<ProductEntity> findByProductId(@Param("productId") String productId);


}
