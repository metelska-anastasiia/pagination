package com.example.pagination.service;

import com.example.pagination.dto.OrderDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    List<OrderDto> findAll(Pageable pageable);

    List<OrderDto> findAll(String email, Pageable pageable);

    OrderDto findById(Long id);
}
