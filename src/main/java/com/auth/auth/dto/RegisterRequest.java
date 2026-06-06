package com.auth.auth.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String nom;

    private String prenom;

    private String numero;

    private String motDePasse;
}