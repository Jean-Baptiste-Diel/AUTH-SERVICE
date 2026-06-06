package com.auth.auth.controller;

import com.auth.auth.entity.PieceIdentiter;
import com.auth.auth.service.PieceIdentiterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piece-identiter")
public class PieceIdentiterController {

    private final PieceIdentiterService service;

    public PieceIdentiterController(
            PieceIdentiterService service
    ) {
        this.service = service;
    }

    @GetMapping
    public List<PieceIdentiter> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PieceIdentiter getById(
            @PathVariable Long id
    ) {
        return service.getById(id);
    }

    @PostMapping
    public PieceIdentiter save(
            @RequestBody PieceIdentiter piece
    ) {
        return service.save(piece);
    }

    @PutMapping("/{id}")
    public PieceIdentiter update(
            @PathVariable Long id,
            @RequestBody PieceIdentiter piece
    ) {
        return service.update(id, piece);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        service.delete(id);
    }
}