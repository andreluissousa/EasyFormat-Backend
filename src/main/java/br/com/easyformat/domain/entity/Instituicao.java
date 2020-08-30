package br.com.easyformat.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instituicao {

    @Id
    private String id;

    private String nome;

    private String UF;

    private String cidade;

   
    private List<Curso> cursos = new ArrayList<Curso>();

    public Instituicao(String id, String nome, String uF, String cidade) {
        this.id = id;
        this.nome = nome;
        UF = uF;
        this.cidade = cidade;
    }

   
   

    
}
