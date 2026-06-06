package com.auth.auth.controller;

import com.auth.auth.models.PieceIdentiter;
import com.auth.auth.service.PieceIdentiterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piece-identiter")
public class PieceIdentiterController {

    private final PieceIdentiterService service;

    public PieceIdentiterController(PieceIdentiterService service) {
        this.service = service;
    }

    @GetMapping
    public List<PieceIdentiter> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PieceIdentiter getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public PieceIdentiter updateById(PieceIdentiter pieceIdentiter) {
        return service.update(pieceIdentiter);
    }

    @PostMapping
    public PieceIdentiter save(@RequestBody PieceIdentiter pieceIdentiter) {
        return service.save(pieceIdentiter);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }
}
