package com.br.wanted.license.model;

import com.br.wanted.license.enums.CatalogType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cdtb_product_prod")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 100)
    private String name;

    @NotBlank @Size(max = 500)
    private String description;

    @NotNull @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @Size(max = 255)
    private String overview;

    private String commands;
    private String permissions;
    private String updates;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CatalogType catalog;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
