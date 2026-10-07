package com.rasky.order.vo;

import com.rasky.order.entity.Order;

public class OrderVO {

    private Order order;
    private ProdukVO produk;
    private PelangganVO pelanggan;

    public OrderVO() {
    }

    public OrderVO(
            Order order,
            ProdukVO produk,
            PelangganVO pelanggan) {

        this.order = order;
        this.produk = produk;
        this.pelanggan = pelanggan;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ProdukVO getProduk() {
        return produk;
    }

    public void setProduk(ProdukVO produk) {
        this.produk = produk;
    }

    public PelangganVO getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(PelangganVO pelanggan) {
        this.pelanggan = pelanggan;
    }
}