package com.auth.auth.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String numero;

    private String motDePasse;
}