package br.com.easyformat.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.easyformat.rest.dto.ObraDTO;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Obra {

    @Id
    private String id;

    private String data;

    private String editora;

    private String titulo;

    private Integer edicao;

    private String local;

    public Obra(ObraDTO obraDTO){
        this.id = obraDTO.getId();
        this.data = obraDTO.getData();
        this.editora = obraDTO.getEditora();
        this.titulo = obraDTO.getTitulo();
        this.edicao = obraDTO.getEdicao();
        this.local = obraDTO.getLocal();
    }
}
