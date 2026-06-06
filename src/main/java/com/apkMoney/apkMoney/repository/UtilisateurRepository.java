package com.apkMoney.apkMoney.repository;

import com.apkMoney.apkMoney.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
   boolean findByNumeroAndMotDePasse(String numero, String motDePasse);
    boolean existsByNumero(String numero);
}
