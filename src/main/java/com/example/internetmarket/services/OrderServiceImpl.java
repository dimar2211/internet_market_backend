package com.example.internetmarket.services;

import com.example.internetmarket.configuration.UserPrinciple;
import com.example.internetmarket.dto.CreateOrderDto;
import com.example.internetmarket.dto.CreateOrderItemDto;
import com.example.internetmarket.models.Order;
import com.example.internetmarket.models.User;
import com.example.internetmarket.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserService userService;

    private final OrderItemService orderItemService;

    private final OrderRepository repository;

    @Override
    public void createOrder(final CreateOrderDto createOrderDto) {
        final UserPrinciple userPrinciple =
                (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        final User user = userService.find(userPrinciple.getId());

        final Order order =  Order.builder()
                .user(user)
                .items(new ArrayList<>()).build();

        final Order savedOrder = repository.save(order);

        createOrderDto.getOrderItems().stream()
                .map(CreateOrderItemDto::toOrderItem)
                .peek(orderItem -> orderItem.setOrder(savedOrder))
                .forEach(orderItemService::save);
    }
}
