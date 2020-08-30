package br.com.easyformat.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.easyformat.rest.dto.CursoDTO;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    private String id;

    private String nome;
    
    public Curso(CursoDTO cursoDTO){
        this.id = cursoDTO.getId();
        this.nome = cursoDTO.getNome();
    }
}
