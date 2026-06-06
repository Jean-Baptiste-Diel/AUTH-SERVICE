package com.auth.auth.controller;

import com.auth.auth.entity.Utilisateur;
import com.auth.auth.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService service;

    public UtilisateurController(
            UtilisateurService service
    ) {
        this.service = service;
    }

    @GetMapping
    public List<Utilisateur> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Utilisateur getById(
            @PathVariable Long id
    ) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Utilisateur update(
            @PathVariable Long id,
            @RequestBody Utilisateur utilisateur
    ) {
        return service.update(id, utilisateur);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        service.delete(id);
    }
}