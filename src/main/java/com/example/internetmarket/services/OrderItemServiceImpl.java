package com.example.internetmarket.services;

import com.example.internetmarket.models.OrderItem;
import com.example.internetmarket.repositories.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements  OrderItemService {

    private final OrderItemRepository repository;

    @Override
    public void save(final OrderItem orderItem) {
        repository.save(orderItem);
    }
}
