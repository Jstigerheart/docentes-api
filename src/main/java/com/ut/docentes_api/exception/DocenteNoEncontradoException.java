package com.ut.docentes_api.exception;

public class DocenteNoEncontradoException extends RuntimeException {
    public DocenteNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}