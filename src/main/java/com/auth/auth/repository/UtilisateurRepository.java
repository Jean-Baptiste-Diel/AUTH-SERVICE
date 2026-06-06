package com.auth.auth.repository;

import com.auth.auth.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Communication avec la base de données pour les utilisateurs.
public interface UtilisateurRepository
        extends JpaRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByNumero(String numero);

    boolean existsByNumero(String numero);
}