package com.example.pagination.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private BigDecimal price;
}
