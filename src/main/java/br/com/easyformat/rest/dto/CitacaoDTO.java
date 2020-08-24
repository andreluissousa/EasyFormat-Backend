package br.com.easyformat.rest.dto;

import br.com.easyformat.domain.entity.Autor;
import br.com.easyformat.domain.entity.Citacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitacaoDTO {
    
    private String id;

    private String texto;

    private Autor autor;

    public CitacaoDTO(Citacao citacao){
        this.id = citacao.getId();
        this.texto = citacao.getTexto();
        this.autor = citacao.getAutor();
    }
}