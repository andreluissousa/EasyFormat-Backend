package br.com.easyformat.domain.entity;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pessoa {
    
    @NotEmpty(message = "O nome é obrigatório")
    private String nome;

    @NotEmpty(message = "O sobrenome é obrigatório")
    private String sobreNome;

    @NotEmpty(message = "Por favor informe a sua formação")
    private String formacao;
    
}