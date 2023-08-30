package com.example.pagination.service;

import com.example.pagination.dto.CreateProductRequestDto;
import com.example.pagination.dto.ProductDto;
import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {
    ProductDto save(CreateProductRequestDto requestDto);

    ProductDto findById(Long id);

    List<ProductDto> findAll(Pageable pageable);

    List<ProductDto> findAllByName(String name);

    void deleteById(Long id);
}
