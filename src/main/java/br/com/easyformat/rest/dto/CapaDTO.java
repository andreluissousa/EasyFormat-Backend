package br.com.easyformat.rest.dto;

import javax.validation.constraints.NotEmpty;
import br.com.easyformat.domain.entity.Capa;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CapaDTO {
    
    private String id;
    @NotEmpty(message = "{capa.titulo}")
    private String titulo;
    @NotEmpty(message = "{capa.subtitulo}")
    private String subTitulo;

    public CapaDTO(Capa capa){
        this.id = capa.getId();
        this.titulo = capa.getTitulo();
        this.subTitulo = capa.getSubTitulo();
    }
}