// src/main/java/com/xp/clientes/xpclienteapi/handler/GlobalExceptionHandler.java

package com.xp.clientes.xpclienteapi.handler;

import com.xp.clientes.xpclienteapi.exception.ValidacaoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice // 1. Diz ao Spring que esta classe lida com exceções de todos os Controllers.
public class GlobalExceptionHandler {

    // 2. Este método será chamado sempre que uma ValidacaoException for lançada
    @ExceptionHandler(ValidacaoException.class)
    @ResponseBody // Indica que o retorno será o corpo da resposta HTTP
    public ResponseEntity<String> handleValidacaoException(ValidacaoException ex) {
        
        // 3. Retorna o status HTTP 400 (Bad Request)
        // e a mensagem de erro que você definiu no Service (Ex: "O nome do cliente é obrigatório.")
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}