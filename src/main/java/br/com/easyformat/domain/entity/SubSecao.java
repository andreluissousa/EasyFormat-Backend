package br.com.easyformat.domain.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import br.com.easyformat.rest.dto.SubSecaoDTO;
import lombok.NoArgsConstructor;

@Document
@NoArgsConstructor
public class SubSecao extends Secao{

    public SubSecao(String id, String titulo, Integer ordem, String conteudo) {
        super(id, titulo, ordem, conteudo);
    }    

    public SubSecao(SubSecaoDTO subSecaoDTO){
        this.setId(subSecaoDTO.getId());
        this.setTitulo(subSecaoDTO.getTitulo());
        this.setConteudo(subSecaoDTO.getConteuto());
        this.setCitacao(subSecaoDTO.getCitacao());
    }
}