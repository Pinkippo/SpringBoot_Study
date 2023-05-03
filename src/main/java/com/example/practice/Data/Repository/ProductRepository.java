package com.example.practice.Data.Repository;

import com.example.practice.Data.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByPname(String pname);

}
