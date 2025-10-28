package com.apkMoney.apkMoney.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String typeRole;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    public Role(int id, String typeRole) {
        this.id = id;
        this.typeRole = typeRole;
    }

    public Role() {

    }
}
