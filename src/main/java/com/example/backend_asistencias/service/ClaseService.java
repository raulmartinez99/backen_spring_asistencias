package com.example.backend_asistencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend_asistencias.entity.Clase;
import com.example.backend_asistencias.repository.ClaseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {
    @Autowired
    private ClaseRepository claseRepository;

    public List<Clase> findAll() {
        return claseRepository.findAll();
    }

    public Optional<Clase> findById(Long id) {
        return claseRepository.findById(id);
    }

    public Clase save(Clase clase) {
        return claseRepository.save(clase);
    }

    public void deleteById(Long id) {
        claseRepository.deleteById(id);
    }
}
