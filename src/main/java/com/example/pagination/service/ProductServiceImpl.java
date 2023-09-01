package com.example.pagination.service;

import com.example.pagination.dto.CreateProductRequestDto;
import com.example.pagination.dto.ProductDto;
import com.example.pagination.mapper.ProductMapper;
import com.example.pagination.model.Product;
import com.example.pagination.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto save(CreateProductRequestDto requestDto) {
        Product product = productMapper.toModel(requestDto);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductDto findById(Long id) {
        return productMapper.toDto(productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find product by id "
                        + id)));
    }

    @Override
    public List<ProductDto> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).stream()
                        .map(productMapper::toDto).toList();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
