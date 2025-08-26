package com.br.wanted.license.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LicenseRequestDTO {

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long userId;

    @NotNull(message = "O ID do produto é obrigatório")
    private Long productId;

    private Integer qntLicense;
    private String licenseIP;
    private String licensePort;
}
