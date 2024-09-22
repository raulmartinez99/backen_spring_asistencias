package com.example.backend_asistencias.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend_asistencias.entity.Asistencia;
import com.example.backend_asistencias.service.AsistenciaService;

import java.util.List;

@RestController
@RequestMapping("/asistencias")
public class AsistenciaController {
    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping
    public List<Asistencia> getAllAsistencias() {
        return asistenciaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> getAsistenciaById(@PathVariable Long id) {
        return asistenciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Asistencia createAsistencia(@RequestBody Asistencia asistencia) {
        return asistenciaService.save(asistencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> updateAsistencia(@PathVariable Long id, @RequestBody Asistencia asistencia) {
        return asistenciaService.findById(id)
                .map(existingAsistencia -> {
                    asistencia.setId(existingAsistencia.getId());
                    return ResponseEntity.ok(asistenciaService.save(asistencia));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsistencia(@PathVariable Long id) {
        if (asistenciaService.findById(id).isPresent()) {
            asistenciaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
