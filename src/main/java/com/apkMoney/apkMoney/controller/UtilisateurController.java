package com.apkMoney.apkMoney.controller;

import com.apkMoney.apkMoney.models.Utilisateur;
import com.apkMoney.apkMoney.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/utilisateurs")
@CrossOrigin(origins = "*")
public class UtilisateurController {
    private final UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }
    @GetMapping
    public List<Utilisateur> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Utilisateur findById(@PathVariable Long id) {
        return service.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Utilisateur save(@RequestBody Utilisateur utilisateur) {
        return service.save(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/connexion")
    public ResponseEntity<Utilisateur> connexion(@RequestBody Utilisateur utilisateur) {
        var result = service.login(utilisateur.getNumero(), utilisateur.getMotDePasse());
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body((Utilisateur) Map.of("message", "Numéro ou mot de passe incorrect ❌")));
    }
}
