package br.com.easyformat.rest.dto;

import javax.validation.constraints.NotEmpty;
import br.com.easyformat.domain.entity.Obra;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ObraDTO {
    
    private String id;
    
    private String data;
    @NotEmpty(message = "{obra.editora}")

    private String editora;
    
    @NotEmpty(message = "{obra.titulo}")
    private String titulo;

    @NotEmpty(message = "{obra.edicao}")
    private Integer edicao;

    @NotEmpty(message = "{obra.local}")
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