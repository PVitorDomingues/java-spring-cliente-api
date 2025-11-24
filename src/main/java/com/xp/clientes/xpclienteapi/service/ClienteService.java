// src/main/java/com/xp/clientes/xpclienteapi/service/ClienteService.java

package com.xp.clientes.xpclienteapi.service;

import com.xp.clientes.xpclienteapi.Cliente;
import com.xp.clientes.xpclienteapi.repository.ClienteRepository;
import com.xp.clientes.xpclienteapi.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marca esta classe como a camada de serviço/lógica (Regra de Negócio)
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Injeção de Dependência: Spring cria uma instância de ClienteRepository e a injeta aqui.
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Método 1: CREATE (Salva um novo cliente)
    public Cliente salvarCliente(Cliente cliente) {
        // LÓGICA DE NEGÓCIO: Validação do nome
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new ValidacaoException("O nome do cliente é obrigatório.");
        }
        return clienteRepository.save(cliente);
    }

    // Método 2: READ (Busca todos os clientes)
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
}