package com.ut.docentes_api.controller;

import com.ut.docentes_api.model.Docente;
import com.ut.docentes_api.service.DocenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/docentes")
@Tag(name = "Docentes", description = "API para gestión de docentes")
public class DocentesController {

    private final DocenteService docenteService;

    public DocentesController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo docente")
    public ResponseEntity<Docente> crearDocente(@RequestBody Docente docente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.crearDocente(docente));
    }

    @GetMapping
    @Operation(summary = "Obtener todos los docentes")
    public ResponseEntity<List<Docente>> obtenerTodos() {
        return ResponseEntity.ok(docenteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener docente por ID")
    public ResponseEntity<Docente> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(docenteService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un docente por ID")
    public ResponseEntity<Docente> actualizarDocente(@PathVariable Long id, @RequestBody Docente docente) {
        return ResponseEntity.ok(docenteService.actualizarDocente(id, docente));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un docente por ID")
    public ResponseEntity<String> eliminarDocente(@PathVariable Long id) {
        docenteService.eliminarDocente(id);
        return ResponseEntity.ok("Docente eliminado correctamente.");
    }
}