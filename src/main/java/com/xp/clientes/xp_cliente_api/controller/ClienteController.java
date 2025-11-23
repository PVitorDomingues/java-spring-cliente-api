// src/main/java/com/xp/clientes/xpclienteapi/controller/ClienteController.java

package com.xp.clientes.xpclienteapi.controller;

import com.xp.clientes.xpclienteapi.Cliente;
import com.xp.clientes.xpclienteapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 1. Diz ao Spring que esta classe gerencia requisições REST
@RequestMapping("/api/clientes") // 2. Define o prefixo da rota base (URL: /api/clientes)
public class ClienteController {

    private final ClienteService clienteService;

    // 3. Injeção de Dependência: O Controller precisa do Service para acessar a lógica.
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Rota 1: POST /api/clientes (CREATE)
    // Recebe um objeto JSON no corpo da requisição e o salva.
    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.salvarCliente(cliente);
        // Retorna o novo cliente e o status HTTP 201 (Created)
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    // Rota 2: GET /api/clientes (READ ALL)
    // Retorna a lista de todos os clientes.
    @GetMapping
    public List<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }
}