package com.apkMoney.apkMoney.service;

import com.apkMoney.apkMoney.models.Utilisateur;
import com.apkMoney.apkMoney.repository.UtilisateurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin(origins = "http://localhost:3000")
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

    public Optional<Utilisateur> login(String numero, String motDePasse) {
        // TODO:
        return repository.findByNumeroAndMotDePasse(numero, motDePasse);
    }
}
