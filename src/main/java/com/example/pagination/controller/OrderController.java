package com.example.pagination.controller;

import com.example.pagination.dto.OrderDto;
import com.example.pagination.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> findAll(Authentication authentication, Pageable pageable) {
        String email = authentication.getName();
        return orderService.findAll(email, pageable);
    }

    @GetMapping("/{id}")
    public OrderDto findById(Long id) {
        return orderService.findById(id);
    }
}
