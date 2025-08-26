package com.br.wanted.license.mapper;

import com.br.wanted.license.dto.UserRequestDTO;
import com.br.wanted.license.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

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
}
