package com.br.wanted.license.repository;

import com.br.wanted.license.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
