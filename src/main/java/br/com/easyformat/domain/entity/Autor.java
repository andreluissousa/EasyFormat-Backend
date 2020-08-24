package br.com.easyformat.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.easyformat.rest.dto.AutorDTO;

@Document
@Getter
@Setter
@NoArgsConstructor
public class Autor extends Pessoa{

    @Id   
    private String id;
   
    private List<Obra> obras = new ArrayList<>();

    public Autor(AutorDTO autorDTO){
        this.id = autorDTO.getId();
        this.setNome(autorDTO.getNome());
        this.setSobreNome(autorDTO.getSobreNome());
    }

}
