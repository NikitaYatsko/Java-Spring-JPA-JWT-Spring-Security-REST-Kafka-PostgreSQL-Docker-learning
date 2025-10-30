package com.post_hub.i_am_service.model.entity;

import com.post_hub.i_am_service.model.enums.RegistrationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users", schema = "i_am_service")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "username", unique = true, nullable = false, length = 30)
    private String username;

    @NotNull
    @Size(max = 80)
    @Column(name = "password", nullable = false, length = 80)
    private String password;

    @Size(max = 50)
    @Column(name = "email", unique = true, length = 50)
    private String email;

    @CreationTimestamp
    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated = LocalDateTime.now();

    @NotNull
    @Column(name = "registration_status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private RegistrationStatus registrationStatus;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @NotNull
    @Column(name = "deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean deleted = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

}
