package com.auth.auth.repository;

import com.auth.auth.Entity.PieceIdentiter;
import org.springframework.data.jpa.repository.JpaRepository;


// CRUD des pièces d'identité.
public interface PieceIdentiterRepository
        extends JpaRepository<PieceIdentiter, Long> {
}