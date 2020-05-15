package com.example.internetmarket.dto;

import com.example.internetmarket.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductInfoDto {

    private Long id;

    private String name;

    private double price;

    private String image;

    private String description;

    public static ProductInfoDto fromProduct(final Product product) {
        return ProductInfoDto.builder()
                .id(product.getId())
                .name(product.getName())
                .image(product.getImage())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
