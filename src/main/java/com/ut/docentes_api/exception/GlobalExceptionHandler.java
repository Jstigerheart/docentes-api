package com.ut.docentes_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DocenteNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> manejarNoEncontrado(DocenteNoEncontradoException ex) {
        return construirRespuesta(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(DocenteDuplicadoException.class)
    public ResponseEntity<Map<String, Object>> manejarDuplicado(DocenteDuplicadoException ex) {
        return construirRespuesta(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> manejarGeneral(Exception ex) {
        return construirRespuesta(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error inesperado: " + ex.getMessage());
    }

    private ResponseEntity<Map<String, Object>> construirRespuesta(HttpStatus status, String mensaje) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("mensaje", mensaje);
        return new ResponseEntity<>(body, status);
    }
}