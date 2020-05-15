package com.example.internetmarket.controllers;

import com.example.internetmarket.dto.CreateOrderDto;
import com.example.internetmarket.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody CreateOrderDto createOrderDto) {
        orderService.createOrder(createOrderDto);
    }
}
