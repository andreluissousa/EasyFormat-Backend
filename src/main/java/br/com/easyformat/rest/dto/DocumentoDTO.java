package br.com.easyformat.rest.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import br.com.easyformat.domain.entity.Capa;
import br.com.easyformat.domain.entity.Documento;
import br.com.easyformat.domain.entity.Secao;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentoDTO {
    
    private String id;

    @NotEmpty(message = "documento.nomeArquivo")
    private String nomeArquivo;

    private Capa capa;

    private List<Secao> secoes = new ArrayList<Secao>();

    public DocumentoDTO(Documento documento){
        this.id = documento.getId();
        this.nomeArquivo = documento.getNomeArquivo();
        this.capa = documento.getCapa();
        this.secoes = documento.getSecoes();
    }

}