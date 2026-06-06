package com.auth.auth.service;

import com.auth.auth.entity.Utilisateur;
import com.auth.auth.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository repository;

    public UtilisateurService(UtilisateurRepository repository) {
        this.repository = repository;
    }

    public List<Utilisateur> getAll() {
        return repository.findAll();
    }

    public Utilisateur getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Utilisateur introuvable"));
    }

    public Utilisateur save(Utilisateur utilisateur) {

        if (repository.existsByNumero(utilisateur.getNumero())) {
            throw new RuntimeException("Numéro déjà utilisé");
        }

        return repository.save(utilisateur);
    }

    public Utilisateur update(Long id, Utilisateur utilisateur) {

        Utilisateur existing = getById(id);

        existing.setNom(utilisateur.getNom());
        existing.setPrenom(utilisateur.getPrenom());
        existing.setNumero(utilisateur.getNumero());
        existing.setMotDePasse(utilisateur.getMotDePasse());

        return repository.save(existing);
    }

    public void delete(Long id) {

        Utilisateur utilisateur = getById(id);

        repository.delete(utilisateur);
    }

    public Utilisateur login(
            String numero,
            String motDePasse
    ) {

        Utilisateur utilisateur =
                repository.findByNumero(numero)
                        .orElseThrow(() ->
                                new RuntimeException("Utilisateur introuvable"));

        if (!utilisateur.getMotDePasse().equals(motDePasse)) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        return utilisateur;
    }
}