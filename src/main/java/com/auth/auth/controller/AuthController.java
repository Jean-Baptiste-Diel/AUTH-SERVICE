package com.auth.auth.controller;

import com.auth.auth.dto.AuthResponse;
import com.auth.auth.dto.LoginRequest;
import com.auth.auth.dto.RegisterRequest;
import com.auth.auth.entity.Utilisateur;
import com.auth.auth.service.UtilisateurService;
import com.auth.auth.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ) {

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setNom(request.getNom());
        utilisateur.setPrenom(request.getPrenom());
        utilisateur.setNumero(request.getNumero());
        utilisateur.setMotDePasse(request.getMotDePasse());

        Utilisateur saved = service.save(utilisateur);

        String token = jwtUtil.generateToken(
                saved.getNumero(),
                saved.getPrenom()
        );

        return ResponseEntity.ok(
                new AuthResponse(
                        true,
                        token,
                        "Compte créé avec succès"
                )
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request
    ) {

        Utilisateur user = service.login(
                request.getNumero(),
                request.getMotDePasse()
        );

        String token = jwtUtil.generateToken(
                user.getNumero(),
                user.getPrenom()
        );

        return ResponseEntity.ok(
                new AuthResponse(
                        true,
                        token,
                        "Connexion réussie"
                )
        );
    }
}