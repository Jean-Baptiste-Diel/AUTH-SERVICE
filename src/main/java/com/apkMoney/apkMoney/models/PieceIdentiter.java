package com.apkMoney.apkMoney.models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
public class PieceIdentiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pieceIdentification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    private Utilisateur utilisateur;

    public PieceIdentiter(int id, String pieceIdentification, Utilisateur utilisateur) {
        this.id = id;
        this.pieceIdentification = pieceIdentification;
        this.utilisateur = utilisateur;
    }
    public PieceIdentiter() {

    }

}
