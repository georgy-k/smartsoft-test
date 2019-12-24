package com.example.smartsofttesttask.Repositories;

import com.example.smartsofttesttask.Domains.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository
        extends CrudRepository<Product, Integer> {
}
