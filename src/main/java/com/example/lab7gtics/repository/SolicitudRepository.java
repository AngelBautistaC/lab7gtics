package com.example.lab7gtics.repository;

import com.example.lab7gtics.entity.Solicitude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface SolicitudRepository extends JpaRepository<Solicitude,Integer> {
}
