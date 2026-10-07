package com.rasky.order.vo;

public class ProdukVO {

    private Long id;
    private String nama;
    private double harga;
    private String deskripsi;
    private Long idJenis;

    public ProdukVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Long getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(Long idJenis) {
        this.idJenis = idJenis;
    }
}