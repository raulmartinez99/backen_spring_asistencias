package com.example.backend_asistencias.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend_asistencias.entity.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    // Métodos de consulta personalizados
}