package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

}
