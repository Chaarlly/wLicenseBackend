package com.br.wanted.license.mapper;

import com.br.wanted.license.dto.UserRequestDTO;
import com.br.wanted.license.dto.UserResponseDTO;
import com.br.wanted.license.model.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserMapper {

    // ✅ MÉTODO toEntity SIMPLES (sem dependências)
    public User toEntity(UserRequestDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setFullName(dto.getFullName());
        user.setUsername(dto.getUsername());
        user.setDiscordId(dto.getDiscordId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setLicense(dto.getLicense());
        user.setRole(dto.getRoleType());
        return user;
    }

    // ✅ MÉTODO toResponse SEM CreditService
    public UserResponseDTO toResponse(User user) {
        if (user == null) return null;

        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setUsername(user.getUsername());
        dto.setDiscordId(user.getDiscordId());
        dto.setEmail(user.getEmail());
        dto.setLicense(user.getLicense());
        dto.setRoleType(user.getRole());
        dto.setCreateAt(user.getCreateAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setCreditBalance(BigDecimal.ZERO); // Valor padrão

        return dto;
    }
}