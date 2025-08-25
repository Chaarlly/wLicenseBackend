package com.br.wanted.license.repository;

import com.br.wanted.license.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFullName(String fullName);
    Optional<User> findByUsername(String username);
    Optional<User> findByDiscordId(String discordId);

}
