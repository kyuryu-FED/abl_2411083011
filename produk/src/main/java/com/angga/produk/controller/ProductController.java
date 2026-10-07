package com.angga.produk.controller;

import com.angga.produk.entity.JenisProduk;
import com.angga.produk.entity.Produk;
import com.angga.produk.service.JenisProdukService;
import com.angga.produk.service.ProdukService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produk")
public class ProductController {

    private final ProdukService produkService;
    private final JenisProdukService jenisProdukService;

    public ProductController(
            ProdukService produkService,
            JenisProdukService jenisProdukService) {

        this.produkService = produkService;
        this.jenisProdukService = jenisProdukService;
    }

    // =========================
    // ENDPOINT PRODUK
    // =========================

    // GET semua produk
    @GetMapping
    public List<Produk> getAllProduk(
            @RequestParam(value = "idjenis", required = false) Long idjenis) {

        return idjenis == null
                ? produkService.getAllProduk()
                : produkService.getAllBarangByIdJenis(idjenis);
    }

    // GET produk berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<Produk> getProdukById(
            @PathVariable Long id) {

        Produk produk = produkService.getProdukById(id);

        if (produk == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produk);
    }

    // POST tambah produk
    @PostMapping
    public ResponseEntity<Produk> createProduk(
            @RequestBody Produk produk) {

        return ResponseEntity.ok(
                produkService.saveProduk(produk)
        );
    }

    // PUT update produk
    @PutMapping("/{id}")
    public ResponseEntity<Produk> updateProduk(
            @PathVariable Long id,
            @RequestBody Produk produk) {

        Produk updated =
                produkService.updateProduk(id, produk);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    // DELETE produk
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduk(
            @PathVariable Long id) {

        produkService.deleteProduk(id);

        return ResponseEntity.noContent().build();
    }


    // =========================
    // ENDPOINT JENIS PRODUK
    // =========================

    // GET semua jenis produk
    @GetMapping("/jenis")
    public List<JenisProduk> getAllJenisProduk() {

        return jenisProdukService.getAllJenisProduk();
    }

    // GET jenis produk berdasarkan ID
    @GetMapping("/jenis/{id}")
    public ResponseEntity<JenisProduk> getJenisProdukById(
            @PathVariable Long id) {

        JenisProduk jenisProduk =
                jenisProdukService.getJenisProdukById(id);

        if (jenisProduk == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(jenisProduk);
    }

    // POST tambah jenis produk
    @PostMapping("/jenis")
    public ResponseEntity<JenisProduk> createJenisProduk(
            @RequestBody JenisProduk jenisProduk) {

        return ResponseEntity.ok(
                jenisProdukService.saveJenisProduk(jenisProduk)
        );
    }

    // PUT update jenis produk
    @PutMapping("/jenis/{id}")
    public ResponseEntity<JenisProduk> updateJenisProduk(
            @PathVariable Long id,
            @RequestBody JenisProduk jenisProduk) {

        JenisProduk updated =
                jenisProdukService.updateJenisProduk(id, jenisProduk);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    // DELETE jenis produk
    @DeleteMapping("/jenis/{id}")
    public ResponseEntity<Void> deleteJenisProduk(
            @PathVariable Long id) {

        jenisProdukService.deleteJenisProduk(id);

        return ResponseEntity.noContent().build();
    }
}