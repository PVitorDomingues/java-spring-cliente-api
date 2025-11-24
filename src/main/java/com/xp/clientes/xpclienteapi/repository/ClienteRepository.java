// src/main/java/com/xp/clientes/xpclienteapi/repository/ClienteRepository.java

package com.xp.clientes.xpclienteapi.repository;

import com.xp.clientes.xpclienteapi.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
// A interface ClienteRepository herda de JpaRepository.
// Isso lhe dá todos os métodos CRUD prontos (save, findAll, delete, etc.).
// Os tipos dentro de <> são: <Entidade que será persistida, Tipo da Chave Primária (ID)>
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}