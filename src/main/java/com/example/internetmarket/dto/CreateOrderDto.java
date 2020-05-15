package com.example.internetmarket.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDto {

    private List<CreateOrderItemDto> orderItems;
}
