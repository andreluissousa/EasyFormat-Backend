package br.com.easyformat.rest.dto;

import br.com.easyformat.domain.entity.Curso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoDTO {
    
    private String id;
    
    private String nome;

    public CursoDTO(Curso curso){
        this.id = curso.getId();
        this.nome = curso.getNome();
    }
}