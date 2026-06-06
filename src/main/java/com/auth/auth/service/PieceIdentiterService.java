package com.auth.auth.service;

import com.auth.auth.models.PieceIdentiter;
import com.auth.auth.repository.PieceIdentiterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceIdentiterService {
    private final PieceIdentiterRepository repository;
    public PieceIdentiterService(PieceIdentiterRepository repository) {
        this.repository = repository;
    }
    public List<PieceIdentiter> getAll() {
        return repository.findAll();
    }
    public PieceIdentiter getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Introuvable"));
    }
    public PieceIdentiter save(PieceIdentiter pieceIdentiter) {
        return repository.save(pieceIdentiter);
    }
    public PieceIdentiter update(PieceIdentiter pieceIdentiter) {
        return repository.save(pieceIdentiter);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
