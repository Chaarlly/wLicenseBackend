package com.br.wanted.license.model;

import com.br.wanted.license.enums.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "cdtb_users_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Usuário é obrigatório")
    private String username;

    private String discordId;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String password;

    @Min(1)
    @Max(10)
    private Integer license = 2;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
