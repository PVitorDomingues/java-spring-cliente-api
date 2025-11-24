// src/test/java/com/xp/clientes/xpclienteapi/service/ClienteServiceTest.java

package com.xp.clientes.xpclienteapi.service;

import com.xp.clientes.xpclienteapi.Cliente;
import com.xp.clientes.xpclienteapi.exception.ValidacaoException;
import com.xp.clientes.xpclienteapi.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Habilita o Mockito no JUnit 5
class ClienteServiceTest {

    // 1. Mock: Simula o ClienteRepository (o banco de dados) para isolar o Service.
    @Mock
    private ClienteRepository clienteRepository;

    // 2. InjectMocks: Injeta o Mock (o Repository falso) na classe que queremos testar (o Service).
    @InjectMocks
    private ClienteService clienteService;

    private Cliente clienteValido;

    @BeforeEach // Roda antes de cada método de teste
    void setUp() {
        // Objeto base para testes, garantindo que ele é VÁLIDO por padrão
        clienteValido = new Cliente();
        clienteValido.setNome("João Silva");
        clienteValido.setCpf("12345678900");
        clienteValido.setEmail("joao@xp.com");
    }

    @Test
    @DisplayName("Deve salvar cliente quando os dados forem válidos")
    void deveSalvarClienteComSucesso() {
        // Define o comportamento do Mock: quando chamar save(), retorna o próprio objeto.
        when(clienteRepository.save(clienteValido)).thenReturn(clienteValido);
        
        clienteService.salvarCliente(clienteValido);
        
        // Verifica se o método save() do Repository foi chamado uma vez (confirma a execução)
        verify(clienteRepository).save(clienteValido);
    }

    @Test
    @DisplayName("Deve lançar ValidacaoException quando o nome for nulo")
    void deveLancarExcecaoQuandoNomeForNulo() {
        // Configura o cenário de falha
        clienteValido.setNome(null); 

        // Confirma se a exceção ValidacaoException é lançada quando o método é executado
        assertThrows(ValidacaoException.class, () -> {
            clienteService.salvarCliente(clienteValido);
        });
        
        // Garante que o método save() NUNCA foi chamado no Repository
        // (A lógica parou antes de acessar o banco)
        verify(clienteRepository, org.mockito.Mockito.times(0)).save(clienteValido);
    }
}