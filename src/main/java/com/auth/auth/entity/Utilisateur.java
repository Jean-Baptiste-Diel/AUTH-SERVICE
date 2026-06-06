package com.auth.auth.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private String prenom;

    @Column(unique = true, nullable = false)
    private String numero;

    @Column(nullable = false)
    private String motDePasse;

    private boolean actif = true;

    private boolean compteVerifie = false;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private PieceIdentiter pieceIdentiter;
}