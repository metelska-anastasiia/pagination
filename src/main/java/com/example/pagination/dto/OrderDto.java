package com.example.pagination.dto;

import com.example.pagination.model.Order;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private LocalDateTime orderDate;
    private Order.Status status;
    private Long userId;
}
