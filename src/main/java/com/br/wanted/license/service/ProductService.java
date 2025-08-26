package com.br.wanted.license.service;

import com.br.wanted.license.dto.ProductRequestDTO;
import com.br.wanted.license.model.Product;
import com.br.wanted.license.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(ProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setOverview(dto.getOverview());
        product.setCommands(dto.getCommands());
        product.setPermissions(dto.getPermissions());
        product.setUpdates(dto.getUpdates());
        product.setCatalog(dto.getCatalog());
        return productRepository.save(product);
    }

    public Product update(Long id, ProductRequestDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setOverview(dto.getOverview());
        product.setCommands(dto.getCommands());
        product.setPermissions(dto.getPermissions());
        product.setUpdates(dto.getUpdates());
        product.setCatalog(dto.getCatalog());

        return productRepository.save(product);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        productRepository.delete(product);
    }
}
