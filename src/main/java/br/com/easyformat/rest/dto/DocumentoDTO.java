package br.com.easyformat.rest.dto;

import java.util.ArrayList;
import java.util.List;
import br.com.easyformat.domain.entity.Capa;
import br.com.easyformat.domain.entity.Secao;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentoDTO {
    
    private String id;

    private String nomeArquivo;

    private String deretorioDocumento;

    private Capa capa;

    private List<Secao> secoes = new ArrayList<>();


}