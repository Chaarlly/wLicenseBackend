package com.br.wanted.license.service;

import com.br.wanted.license.dto.UserRequestDTO;
import com.br.wanted.license.dto.UserResponseDTO;
import com.br.wanted.license.model.User;
import com.br.wanted.license.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO create(UserRequestDTO request) {
        User user = new User();
        user.setFullName(request.getFullName());
        user.setUsername(request.getUsername());
        user.setDiscordId(request.getDiscordId());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setLicense(request.getLicense());
        user.setRole(request.getRoleType());

        userRepository.save(user);
        return toResponse(user);
    }

    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> users = userRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return toResponse(user);
    }

    public UserResponseDTO update(Long id, UserRequestDTO request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setFullName(request.getFullName());
        user.setUsername(request.getUsername());
        user.setDiscordId(request.getDiscordId());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRoleType());
        userRepository.save(user);
        return toResponse(user);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        userRepository.delete(user);
    }


    private UserResponseDTO toResponse(User user) {
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
        return dto;
    }

    public Optional<User> findEntityById(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> findEntityByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getEntityById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public User getEntityByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public User getCurrentUser() {
        throw new RuntimeException("Método getCurrentUser não implementado");
    }
}