package com.example.pagination.mapper;

import com.example.pagination.config.MapperConfig;
import com.example.pagination.dto.CreateProductRequestDto;
import com.example.pagination.dto.ProductDto;
import com.example.pagination.model.Product;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toModel(CreateProductRequestDto requestDto);
}
