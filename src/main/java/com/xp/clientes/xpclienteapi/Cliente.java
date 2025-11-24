// src/main/java/com/xp/clientes/xpclienteapi/Cliente.java

package com.xp.clientes.xpclienteapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; 

@Entity // Diz ao JPA (a biblioteca de persistência) que esta classe é uma tabela no banco de dados.
@Data   // Anotação do Lombok que gera automaticamente getters, setters e construtores. Reduz muito o código!
public class Cliente {

    @Id // Define este campo como a chave primária (a coluna que identifica unicamente cada registro).
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Diz ao banco H2 para gerar o ID automaticamente.
    private Long id;

    // Campos do nosso Cliente
    private String nome;
    private String cpf; 
    private String email;

}