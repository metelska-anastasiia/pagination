package com.example.pagination.service;

import com.example.pagination.dto.OrderDto;
import com.example.pagination.mapper.OrderMapper;
import com.example.pagination.model.User;
import com.example.pagination.repository.OrderRepository;
import com.example.pagination.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderDto> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable).stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public List<OrderDto> findAll(String email, Pageable pageable) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Can't find user by email "
                        + email));
        return orderRepository.findAllByUserId(user.getId())
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public OrderDto findById(Long id) {
        return orderMapper.toDto(orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find order by id " + id)));
    }
}
