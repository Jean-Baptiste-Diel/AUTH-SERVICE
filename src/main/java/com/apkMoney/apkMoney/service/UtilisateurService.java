package com.apkMoney.apkMoney.service;

import com.apkMoney.apkMoney.models.Utilisateur;
import com.apkMoney.apkMoney.repository.UtilisateurRepository;
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
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Introuvable"));
    }

    public Utilisateur save(Utilisateur utilisateur) {
        return repository.save(utilisateur);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public boolean login(String numero, String motDePasse) {
        return repository.findByNumeroAndMotDePasse(numero, motDePasse);
    }
}
