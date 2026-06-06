package com.auth.auth.repository;

import com.auth.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// Permet de récupérer les rôles.
public interface RoleRepository
        extends JpaRepository<Role, Long> {

    Optional<Role> findByTypeRole(String typeRole);
}