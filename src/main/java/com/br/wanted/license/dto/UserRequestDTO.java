package com.br.wanted.license.dto;

import com.br.wanted.license.enums.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank(message = "Nome completo é obrigatório")
    private String fullName;

    @NotBlank(message = "Usuário é obrigatório")
    private String username;

    private String discordId;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String password;

    @Min(1)
    @Max(10)
    private Integer license = 2;

    private RoleType roleType; // ✅ ESTÁ CORRETO (roleType)
}