package com.rasky.pelanggan.controller;

import com.rasky.pelanggan.entity.Pelanggan;
import com.rasky.pelanggan.repository.PelangganRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

    private final PelangganRepository repository;

    public PelangganController(PelangganRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pelanggan> getAllPelanggan() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pelanggan getPelangganById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Pelanggan createPelanggan(@RequestBody Pelanggan pelanggan) {
        return repository.save(pelanggan);
    }

    @PutMapping("/{id}")
    public Pelanggan updatePelanggan(
            @PathVariable Long id,
            @RequestBody Pelanggan data) {

        Pelanggan pelanggan = repository.findById(id).orElse(null);

        if (pelanggan == null) {
            return null;
        }

        pelanggan.setNama(data.getNama());
        pelanggan.setEmail(data.getEmail());
        pelanggan.setNoHp(data.getNoHp());
        pelanggan.setAlamat(data.getAlamat());

        return repository.save(pelanggan);
    }

    @DeleteMapping("/{id}")
    public String deletePelanggan(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return "Pelanggan tidak ditemukan";
        }

        repository.deleteById(id);

        return "Pelanggan berhasil dihapus";
    }
}