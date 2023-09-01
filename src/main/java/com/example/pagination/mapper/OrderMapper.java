package com.example.pagination.mapper;

import com.example.pagination.config.MapperConfig;
import com.example.pagination.dto.OrderDto;
import com.example.pagination.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface OrderMapper {
    @Mapping(source = "user.id", target = "userId")
    OrderDto toDto(Order order);

    //Order toModel(OrderDto orderDto);

}
