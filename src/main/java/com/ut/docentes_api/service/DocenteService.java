package com.ut.docentes_api.service;

import com.ut.docentes_api.exception.DocenteDuplicadoException;
import com.ut.docentes_api.exception.DocenteNoEncontradoException;
import com.ut.docentes_api.model.Docente;
import com.ut.docentes_api.repository.DocenteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    public Docente crearDocente(Docente docente) {
        docenteRepository.findByTipoDocumentoAndNumeroDocumento(
            docente.getTipoDocumento(), docente.getNumeroDocumento()
        ).ifPresent(d -> {
            throw new DocenteDuplicadoException("Ya existe un docente con ese tipo y número de documento.");
        });
        return docenteRepository.save(docente);
    }

    public List<Docente> obtenerTodos() {
        return docenteRepository.findAll();
    }

    public Docente obtenerPorId(Long id) {
        return docenteRepository.findById(id)
            .orElseThrow(() -> new DocenteNoEncontradoException("Docente no encontrado con ID: " + id));
    }

    public Docente actualizarDocente(Long id, Docente docenteActualizado) {
        Docente docente = docenteRepository.findById(id)
            .orElseThrow(() -> new DocenteNoEncontradoException("Docente no encontrado con ID: " + id));

        docente.setNombre(docenteActualizado.getNombre());
        docente.setApellido(docenteActualizado.getApellido());
        docente.setEmail(docenteActualizado.getEmail());
        docente.setEspecialidad(docenteActualizado.getEspecialidad());
        docente.setTipoDocumento(docenteActualizado.getTipoDocumento());
        docente.setNumeroDocumento(docenteActualizado.getNumeroDocumento());

        return docenteRepository.save(docente);
    }

    public void eliminarDocente(Long id) {
        docenteRepository.findById(id)
            .orElseThrow(() -> new DocenteNoEncontradoException("Docente no encontrado con ID: " + id));
        docenteRepository.deleteById(id);
    }
}