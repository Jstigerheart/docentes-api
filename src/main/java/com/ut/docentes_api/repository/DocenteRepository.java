package com.ut.docentes_api.repository;

import com.ut.docentes_api.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Long> {

    Optional<Docente> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
}
