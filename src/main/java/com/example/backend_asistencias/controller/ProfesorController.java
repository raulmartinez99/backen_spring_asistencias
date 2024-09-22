package com.example.backend_asistencias.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend_asistencias.entity.Asignatura;
import com.example.backend_asistencias.entity.Profesor;
import com.example.backend_asistencias.service.ProfesorService;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<Profesor> getAllProfesores() {
        return profesorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Long id) {
        return profesorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Profesor createProfesor(@RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> updateProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        return profesorService.findById(id)
                .map(existingProfesor -> {
                    profesor.setId(existingProfesor.getId());
                    return ResponseEntity.ok(profesorService.save(profesor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable Long id) {
        if (profesorService.findById(id).isPresent()) {
            profesorService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

     @PutMapping("/{id}/asignaturas")
    public ResponseEntity<Profesor> addAsignaturasToProfesor(
            @PathVariable Long id,
            @RequestBody List<Asignatura> asignaturas) {
        return profesorService.findById(id)
                .map(existingProfesor -> {
                    existingProfesor.getAsignaturas().addAll(asignaturas); // Agregar las nuevas asignaturas
                    return ResponseEntity.ok(profesorService.save(existingProfesor));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
