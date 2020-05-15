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
public class CreateProductDto {

    private String name;

    private double price;

    private String image;

    private String description;

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .image(image)
                .description(description)
                .price(price).build();
    }
}
