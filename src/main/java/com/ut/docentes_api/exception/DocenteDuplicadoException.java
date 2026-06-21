package com.ut.docentes_api.exception;

public class DocenteDuplicadoException extends RuntimeException {
    public DocenteDuplicadoException(String mensaje) {
        super(mensaje);
    }
}