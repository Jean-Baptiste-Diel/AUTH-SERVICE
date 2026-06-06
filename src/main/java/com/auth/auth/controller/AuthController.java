package com.auth.auth.controller;

import com.auth.auth.entity.Utilisateur;
import com.auth.auth.service.UtilisateurService;
import com.auth.auth.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


// Uniquement l'inscription et la connexion.
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UtilisateurService service;
    private final JwtUtil jwtUtil;

    public AuthController(
            UtilisateurService service,
            JwtUtil jwtUtil
    ) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody Utilisateur utilisateur
    ) {

        Utilisateur saved =
                service.save(utilisateur);

        String token =
                jwtUtil.generateToken(
                        saved.getNumero(),
                        saved.getPrenom()
                );

        return ResponseEntity.ok(
                Map.of(
                        "success", true,
                        "token", token
                )
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody Utilisateur utilisateur
    ) {

        Utilisateur user =
                service.login(
                        utilisateur.getNumero(),
                        utilisateur.getMotDePasse()
                );

        String token =
                jwtUtil.generateToken(
                        user.getNumero(),
                        user.getPrenom()
                );

        return ResponseEntity.ok(
                Map.of(
                        "success", true,
                        "token", token
                )
        );
    }
}