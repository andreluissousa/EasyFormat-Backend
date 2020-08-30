package br.com.easyformat.rest.dto;

import javax.validation.constraints.NotEmpty;
import br.com.easyformat.domain.entity.Autor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AutorDTO {
    
    private String id;
    @NotEmpty(message = "{nome}")
    private String nome;
    @NotEmpty(message = "{sobrenome}")
    private String sobrenome;

    public AutorDTO(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.sobrenome = autor.getSobrenome();
    }
}