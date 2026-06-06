package com.auth.auth.service;

import com.auth.auth.Entity.PieceIdentiter;
import com.auth.auth.repository.PieceIdentiterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Gestion des pièces d'identité.
@Service
public class PieceIdentiterService {

    private final PieceIdentiterRepository repository;

    public PieceIdentiterService(
            PieceIdentiterRepository repository
    ) {
        this.repository = repository;
    }

    public List<PieceIdentiter> getAll() {
        return repository.findAll();
    }

    public PieceIdentiter getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pièce introuvable"));
    }

    public PieceIdentiter save(PieceIdentiter piece) {
        return repository.save(piece);
    }

    public PieceIdentiter update(
            Long id,
            PieceIdentiter piece
    ) {

        PieceIdentiter existing = getById(id);

        existing.setPieceIdentification(
                piece.getPieceIdentification()
        );

        return repository.save(existing);
    }

    public void delete(Long id) {

        PieceIdentiter piece = getById(id);

        repository.delete(piece);
    }
}