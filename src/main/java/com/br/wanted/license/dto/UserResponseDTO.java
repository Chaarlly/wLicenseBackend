package com.br.wanted.license.dto;

import com.br.wanted.license.enums.RoleType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDTO {

    private Long id;
    private String fullName;
    private String username;
    private String discordId;
    private String email;
    private Integer license;
    private RoleType roleType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
