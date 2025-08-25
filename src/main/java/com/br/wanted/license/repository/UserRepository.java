package com.br.wanted.license.repository;

import com.br.wanted.license.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ✅ MÉTODO NOVO - Buscar usuário por username
    Optional<User> findByUsername(String username);

    // ✅ MÉTODO NOVO - Buscar usuário por email
    Optional<User> findByEmail(String email);

    // ✅ MÉTODO NOVO - Verificar se username existe
    Boolean existsByUsername(String username);

    // ✅ MÉTODO NOVO - Verificar se email existe
    Boolean existsByEmail(String email);

}
