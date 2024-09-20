package dev.ggorantala.resumebuilder.service;

import dev.ggorantala.resumebuilder.dto.ProductRequest;
import dev.ggorantala.resumebuilder.dto.ProductResponse;
import dev.ggorantala.resumebuilder.model.Product;
import dev.ggorantala.resumebuilder.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Copyright © 2024 by Gopi Gorantala, MIT License.
 *
 * @author Gopi Gorantala
 * Date: 19/09/24
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder() //
            .name(productRequest.getName()) //
            .description(productRequest.getDescription()) //
            .price(productRequest.getPrice()) //
            .build(); // to create the object with type Product

        productRepository.save(product);

        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder() //
            .id(product.getId()) //
            .name(product.getName()) //
            .description(product.getDescription()) //
            .price(product.getPrice()) //
            .build();
    }
}
