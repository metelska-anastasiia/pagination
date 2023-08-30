package com.example.pagination.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProductRequestDto {
    @NotNull
    private String title;
    @NotNull
    @Min(0)
    private BigDecimal price;
}
