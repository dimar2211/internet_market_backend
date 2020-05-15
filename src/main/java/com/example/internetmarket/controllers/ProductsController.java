package com.example.internetmarket.controllers;

import com.example.internetmarket.dto.CreateProductDto;
import com.example.internetmarket.dto.EditProductDto;
import com.example.internetmarket.dto.ProductInfoDto;
import com.example.internetmarket.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody final CreateProductDto createProductDto) {
        productService.createProduct(createProductDto);
    }

    @PutMapping
    public void createProduct(@RequestBody final EditProductDto editProductDto) {
        productService.editProduct(editProductDto);
    }

    @GetMapping
    public List<ProductInfoDto> getProducts(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                                            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                                            @RequestParam(value = "sort", defaultValue = "name", required = false) String sort,
                                            @RequestParam(value = "type", defaultValue = "ASC", required = false) Sort.Direction type) {
        return productService.getProducts(PageRequest.of(page, size, type, sort));
    }

    @DeleteMapping("{id}")
    public void createProduct(@PathVariable final Long id) {
        productService.deleteProduct(id);
    }
}
