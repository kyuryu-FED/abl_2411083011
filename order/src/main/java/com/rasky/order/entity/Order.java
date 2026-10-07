package com.rasky.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long produkId;
    private Long pelangganId;
    private String tglTrans;
    private Integer jumlah;
    private Double total;

    public Order() {
    }

    public Order(Long produkId, Long pelangganId, String tglTrans,
                 Integer jumlah, Double total) {
        this.produkId = produkId;
        this.pelangganId = pelangganId;
        this.tglTrans = tglTrans;
        this.jumlah = jumlah;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdukId() {
        return produkId;
    }

    public void setProdukId(Long produkId) {
        this.produkId = produkId;
    }

    public Long getPelangganId() {
        return pelangganId;
    }

    public void setPelangganId(Long pelangganId) {
        this.pelangganId = pelangganId;
    }

    public String getTglTrans() {
        return tglTrans;
    }

    public void setTglTrans(String tglTrans) {
        this.tglTrans = tglTrans;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}