package com.apkMoney.apkMoney.service;

import com.apkMoney.apkMoney.models.PieceIdentiter;
import com.apkMoney.apkMoney.repository.PieceIdentiterRepository;
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
