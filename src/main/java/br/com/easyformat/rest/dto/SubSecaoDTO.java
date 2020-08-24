package br.com.easyformat.rest.dto;

import br.com.easyformat.domain.entity.Secao;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SubSecaoDTO extends SecaoDTO {
    public SubSecaoDTO(Secao secao) {
        super(secao);
    }
}