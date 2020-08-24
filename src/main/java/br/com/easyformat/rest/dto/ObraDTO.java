package br.com.easyformat.rest.dto;

import br.com.easyformat.domain.entity.Obra;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ObraDTO {
    
    private String id;
    
    private String data;

    private String editora;
    
    private String titulo;

    private Integer edicao;

    private String local;

    public ObraDTO(Obra obra){
        this.id = obra.getId();
        this.data = obra.getData();
        this.editora = obra.getEditora();
        this.titulo = obra.getTitulo();
        this.edicao = obra.getEdicao();
        this.local = obra.getLocal();
    }

}