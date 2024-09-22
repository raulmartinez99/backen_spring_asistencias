package com.example.backend_asistencias.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "estudiante_id") 
    private Estudiante estudiante; 

    @ManyToOne
    @JoinColumn(name = "clase_id") 
    private Clase clase; 

    private String asistencia;

    private LocalDateTime fechaHora;

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAsistencia() { return asistencia; }
    public void setId(String asistencia) { this.asistencia= asistencia; }
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    public Clase getClase() { return clase; }
    public void setClase(Clase clase) { this.clase = clase; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
}