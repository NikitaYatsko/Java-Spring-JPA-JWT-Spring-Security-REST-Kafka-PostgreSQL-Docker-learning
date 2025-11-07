package com.post_hub.i_am_service.model.entity;

import com.post_hub.i_am_service.service.model.IamServiceUserRole;
import com.post_hub.i_am_service.utils.enums.UserRoleTypeConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "roles", schema = "i_am_service")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "user_system_role")
    @Convert(converter = UserRoleTypeConverter.class)
    private IamServiceUserRole userSystemRoles;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "created_by")
    private String createdBy;
    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<User> users = new HashSet<>();

}
