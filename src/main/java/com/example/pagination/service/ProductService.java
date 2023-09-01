package com.example.pagination.service;

import com.example.pagination.dto.CreateProductRequestDto;
import com.example.pagination.dto.ProductDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductDto save(CreateProductRequestDto requestDto);

    ProductDto findById(Long id);

    List<ProductDto> findAll(Pageable pageable);

    void deleteById(Long id);
}
