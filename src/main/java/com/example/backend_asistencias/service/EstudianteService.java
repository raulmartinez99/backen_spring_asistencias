package com.example.backend_asistencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend_asistencias.entity.Estudiante;
import com.example.backend_asistencias.repository.EstudianteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> findById(Long id) {
        return estudianteRepository.findById(id);
    }

    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public void deleteById(Long id) {
        estudianteRepository.deleteById(id);
    }
}
