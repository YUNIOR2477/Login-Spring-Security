package com.app.entity.User;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "nombre_usuario")
    private String userName;

    @Column(name = "contrasena")
    private String password;

    @Column(name = "habilitado?")
    private boolean isEnabled;

    @Column(name = "expirado?")
    private boolean accountNoExpired;

    @Column(name = "bloqueado?")
    private boolean accountNoLocked;

    @Column(name = "credencial_expirada?")
    private boolean credentialNoExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "roles_usuarios", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<RoleEntity> roles = new HashSet<>();
}
