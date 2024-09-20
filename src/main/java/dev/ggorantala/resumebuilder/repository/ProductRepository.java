package dev.ggorantala.resumebuilder.repository;

import dev.ggorantala.resumebuilder.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * Copyright © 2024 by Gopi Gorantala, MIT License.
 *
 * @author Gopi Gorantala
 * Date: 19/09/24
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
