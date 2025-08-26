package com.br.wanted.license.dto;

import com.br.wanted.license.enums.CatalogType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {

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
    private CatalogType catalog;
}
