// src/main/java/com/xp/clientes/xpclienteapi/exception/ValidacaoException.java

package com.xp.clientes.xpclienteapi.exception;

// Esta classe herda de RuntimeException, que é a exceção padrão do Java.
public class ValidacaoException extends RuntimeException {

    // Construtor que aceita uma mensagem (o motivo da falha)
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}