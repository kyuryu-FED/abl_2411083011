package com.rasky.pelanggan.repository;

import com.rasky.pelanggan.entity.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {

}