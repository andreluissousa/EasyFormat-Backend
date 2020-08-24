package br.com.easyformat.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pessoa {
    
    private String nome;

    private String sobreNome;

    private String formacao;
    
}