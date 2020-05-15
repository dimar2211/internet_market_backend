package com.example.internetmarket.services;

import com.example.internetmarket.dto.CreateProductDto;
import com.example.internetmarket.dto.EditProductDto;
import com.example.internetmarket.dto.ProductInfoDto;
import com.example.internetmarket.models.Product;
import com.example.internetmarket.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public void createProduct(final CreateProductDto createProductDto) {
        repository.save(createProductDto.toProduct());
    }

    @Override
    public void editProduct(final EditProductDto editProductDto) {
        final Product product = repository.getOne(editProductDto.getId());
        editProductDto.update(product);

        repository.save(product);
    }

    @Override
    public void deleteProduct(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProductInfoDto> getProducts(final PageRequest pageRequest) {
        final Page<Product> recordsPage = repository.findAll(pageRequest);
        return recordsPage.getContent().stream()
                .map(ProductInfoDto::fromProduct)
                .collect(toList());
    }
}
