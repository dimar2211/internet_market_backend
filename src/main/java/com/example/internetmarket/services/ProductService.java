package com.example.internetmarket.services;

import com.example.internetmarket.dto.CreateProductDto;
import com.example.internetmarket.dto.EditProductDto;
import com.example.internetmarket.dto.ProductInfoDto;
import com.example.internetmarket.models.Product;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductService {

    void createProduct(CreateProductDto createProductDto);

    void editProduct(EditProductDto editProductDto);

    void deleteProduct(Long id);

    List<ProductInfoDto> getProducts(PageRequest pageRequest);
}
