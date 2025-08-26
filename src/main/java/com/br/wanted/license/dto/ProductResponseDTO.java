package com.br.wanted.license.dto;

import com.br.wanted.license.enums.CatalogType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String overview;
    private String commands;
    private String permissions;
    private String updates;
    private CatalogType catalog;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
