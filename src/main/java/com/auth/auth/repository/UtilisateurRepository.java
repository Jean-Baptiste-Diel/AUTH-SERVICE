package com.auth.auth.repository;

import com.auth.auth.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
   boolean findByNumeroAndMotDePasse(String numero, String motDePasse);
    boolean existsByNumero(String numero);
}
