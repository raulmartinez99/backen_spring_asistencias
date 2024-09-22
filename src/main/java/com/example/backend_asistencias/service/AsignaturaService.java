package com.example.backend_asistencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_asistencias.entity.Asignatura;
import com.example.backend_asistencias.repository.AsignaturaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<Asignatura> findAll() {
        return asignaturaRepository.findAll();
    }

    public Optional<Asignatura> findById(Long id) {
        return asignaturaRepository.findById(id);
    }

    public Asignatura save(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public void deleteById(Long id) {
        asignaturaRepository.deleteById(id);
    }
}
