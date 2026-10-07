package com.rasky.order.controller;

import com.rasky.order.entity.Order;
import com.rasky.order.repository.OrderRepository;
import com.rasky.order.vo.OrderVO;
import com.rasky.order.vo.ProdukVO;
import com.rasky.order.vo.PelangganVO;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderRepository repository;
    private final RestClient restClient;

    public OrderController(
            OrderRepository repository,
            RestClient restClient) {

        this.repository = repository;
        this.restClient = restClient;
    }

    // GET semua order
    @GetMapping
    public List<Order> getAllOrder() {
        return repository.findAll();
    }

    // GET order berdasarkan ID + data Produk + Pelanggan
    @GetMapping("/{id}")
    public OrderVO getOrderById(@PathVariable Long id) {

        Order order = repository.findById(id).orElse(null);

        if (order == null) {
            return null;
        }

        // Ambil data Produk
        ProdukVO produk = restClient.get()
                .uri("http://localhost:8080/api/produk/"
                        + order.getProdukId())
                .retrieve()
                .body(ProdukVO.class);

        // Ambil data Pelanggan
        PelangganVO pelanggan = restClient.get()
                .uri("http://localhost:8081/api/pelanggan/"
                        + order.getPelangganId())
                .retrieve()
                .body(PelangganVO.class);

        return new OrderVO(
                order,
                produk,
                pelanggan
        );
    }

    // POST order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return repository.save(order);
    }

    // PUT order
    @PutMapping("/{id}")
    public Order updateOrder(
            @PathVariable Long id,
            @RequestBody Order data) {

        Order order = repository.findById(id).orElse(null);

        if (order == null) {
            return null;
        }

        order.setProdukId(data.getProdukId());
        order.setPelangganId(data.getPelangganId());
        order.setTglTrans(data.getTglTrans());
        order.setJumlah(data.getJumlah());
        order.setTotal(data.getTotal());

        return repository.save(order);
    }

    // DELETE order
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return "Order tidak ditemukan";
        }

        repository.deleteById(id);

        return "Order berhasil dihapus";
    }
}