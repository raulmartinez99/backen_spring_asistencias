package com.example.backend_asistencias.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend_asistencias.entity.Asignatura;
import com.example.backend_asistencias.service.AsignaturaService;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    //AQUI OBTENGO LA LISTA DE LAS ASIGTATURAS REGISTRADAS
    public List<Asignatura> getAllAsignaturas() {
        return asignaturaService.findAll();
    }

    @GetMapping("/{id}")
    //AQUI OBTENGO LAS ASIGNATURAS CON EL ID
    public ResponseEntity<Asignatura> getAsignaturaById(@PathVariable Long id) {
        return asignaturaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    //AQUI CREO UNA NUEVA ASEGNATURA, PASANDOLE EL JSON CON LOS ATRIBUTOS DE ASIGNATURAS
    public Asignatura createAsignatura(@RequestBody Asignatura asignatura) {
        return asignaturaService.save(asignatura);
    }

    @PutMapping("/{id}")
    //AQUI ACTUALIZO LA ASIGNATURA, PASANDOLE EL ID DE LA ASIGNATURA, Y EL NUEVO JSON DE LA ASIGNATURA
    public ResponseEntity<Asignatura> updateAsignatura(@PathVariable Long id, @RequestBody Asignatura asignatura) {
        return asignaturaService.findById(id)
                .map(existingAsignatura -> {
                    asignatura.setId(existingAsignatura.getId());
                    return ResponseEntity.ok(asignaturaService.save(asignatura));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    //AQUI BORRO LA ASIGNATURA PASANDOLE EL ID DE LAS ASOGNATURA
    public ResponseEntity<Void> deleteAsignatura(@PathVariable Long id) {
        if (asignaturaService.findById(id).isPresent()) {
            asignaturaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
