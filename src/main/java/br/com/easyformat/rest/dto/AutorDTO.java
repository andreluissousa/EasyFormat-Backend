package br.com.easyformat.rest.dto;

import br.com.easyformat.domain.entity.Autor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AutorDTO {
    
    private String id;
    private String nome;
    private String sobrenome;

    public AutorDTO(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.sobrenome = autor.getSobrenome();
    }
}