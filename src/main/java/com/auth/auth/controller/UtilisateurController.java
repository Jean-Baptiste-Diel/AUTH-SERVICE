package com.auth.auth.controller;

import com.auth.auth.models.Utilisateur;
import com.auth.auth.service.UtilisateurService;
import com.auth.auth.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/utilisateurs")
@CrossOrigin(origins = "*")
public class UtilisateurController {
    private final UtilisateurService service;
    private final JwtUtil jwtUtil;

    public UtilisateurController(UtilisateurService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/test")
    public String test() {
        return "Auth Service OK";
    }

    @GetMapping
    public List<Utilisateur> getAll() {
        System.out.println(HttpStatus.OK);
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Utilisateur findById(@PathVariable Long id) {
        return service.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/inscription")
    public ResponseEntity<Map<String, Serializable>> save(@RequestBody Utilisateur utilisateur) {
        service.save(utilisateur);
        String token = jwtUtil.generateToken(utilisateur.getNumero(), utilisateur.getPrenom());
        return ResponseEntity.ok(Map.of(
                "success", true,
                "token", token
        ));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/connexion")
    public ResponseEntity<?> connexion(@RequestBody Utilisateur utilisateur) {
        if (service.login(utilisateur.getNumero(), utilisateur.getMotDePasse())) {
            String token = jwtUtil.generateToken(utilisateur.getNumero(), utilisateur.getPrenom());
            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "token", token
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "success", false,
                    "message", "Numéro ou mot de passe incorrect ❌"
            ));
        }
    }

}
