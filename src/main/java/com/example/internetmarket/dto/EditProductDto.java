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
public class EditProductDto {

    private Long id;

    private String name;

    private double price;

    private String image;

    private String description;

    public void update(final Product product) {
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setImage(image);
    }
}
