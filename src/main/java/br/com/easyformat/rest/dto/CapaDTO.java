package br.com.easyformat.rest.dto;

import br.com.easyformat.domain.entity.Capa;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CapaDTO {
    
    private String id;
    private String titulo;
    private String subTitulo;

    public CapaDTO(Capa capa){
        this.id = capa.getId();
        this.titulo = capa.getTitulo();
        this.subTitulo = capa.getSubTitulo();
    }
}