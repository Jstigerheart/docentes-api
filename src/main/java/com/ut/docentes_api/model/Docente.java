package com.ut.docentes_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroDocumento;

    @Column(nullable = false)
    private String tipoDocumento;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String especialidad;

    public Docente() {}

    public Docente(Long id, String numeroDocumento, String tipoDocumento, String nombre, String apellido, String email, String especialidad) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.especialidad = especialidad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}