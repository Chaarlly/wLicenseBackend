package com.br.wanted.license.model;

import com.br.wanted.license.enums.LicenseType;
import com.br.wanted.license.enums.RoleType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CDTB_USER_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String username;

    private String discordId;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private LocalDateTime createdAt;

    // 1:N -> um usuário pode ter várias licenças
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<License> licenses = new ArrayList<>();

}
