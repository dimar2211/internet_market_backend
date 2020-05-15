package com.example.internetmarket.dto;

import com.example.internetmarket.models.OrderItem;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderItemDto {

    private Long productId;

    private Long count;

    public OrderItem toOrderItem() {
        return OrderItem.builder()
                .count(count)
                .product(productId).build();
    }
}
