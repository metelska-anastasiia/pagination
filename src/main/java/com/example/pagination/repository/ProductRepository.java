package com.example.pagination.repository;

import com.example.pagination.model.Product;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product, Long>,
        JpaSpecificationExecutor<Product> {
    List<Product> findAllByNameContainingIgnoreCase(String name);

    Page<Product> findAll(Pageable pageable);
}

