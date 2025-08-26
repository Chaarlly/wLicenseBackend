package com.br.wanted.license.dto;

import com.br.wanted.license.enums.RoleType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank
    private String fullName;

    @NotBlank
    private String username;

    private String discordId;

    @NotBlank @Email
    private String email;

    @NotBlank
    private String password;

    @Min(1) @Max(10)
    private Integer license = 2;

    private RoleType roleType;
}
