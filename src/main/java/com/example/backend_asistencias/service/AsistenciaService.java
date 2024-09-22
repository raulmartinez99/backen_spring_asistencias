package com.example.backend_asistencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_asistencias.entity.Asistencia;
import com.example.backend_asistencias.repository.AsistenciaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {
    @Autowired
    private AsistenciaRepository asistenciaRepository;

    public List<Asistencia> findAll() {
        return asistenciaRepository.findAll();
    }

    public Optional<Asistencia> findById(Long id) {
        return asistenciaRepository.findById(id);
    }

    public Asistencia save(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    public void deleteById(Long id) {
        asistenciaRepository.deleteById(id);
    }
}
