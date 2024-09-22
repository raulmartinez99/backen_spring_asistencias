package com.example.backend_asistencias.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backend_asistencias.entity.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    // Aquí puedes agregar métodos de consulta personalizados si es necesario
}
