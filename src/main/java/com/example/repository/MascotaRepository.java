package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{

	// Con JpaRRepository ya se heredaron todos los metodos(DML)
}
