package com.br.wanted.license.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LicenseResponseDTO {

    private Long id;
    private Long userId;
    private Long productId;
    private String licenseKey;
    private Integer qntLicense;
    private String licenseIP;
    private String licensePort;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
