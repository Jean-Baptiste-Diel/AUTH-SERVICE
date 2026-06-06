package com.auth.auth.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String numero;
    private String motDePasse;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Utilisateur(int id, String nom, String prenom, String numero, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.motDePasse = motDePasse;
    }

    public Utilisateur() {

    }
}
