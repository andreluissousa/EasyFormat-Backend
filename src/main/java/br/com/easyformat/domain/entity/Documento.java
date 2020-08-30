package br.com.easyformat.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.easyformat.rest.dto.DocumentoDTO;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@NoArgsConstructor
public class Documento {

    @Id
    private String id;

    private String nomeArquivo;

    private Capa capa;

    private List<Secao> secoes = new ArrayList<Secao>();

    public Documento(String id, String nomeArquivo, Capa capa) {
        this.id = id;
        this.nomeArquivo = nomeArquivo;
        this.capa = capa;
    }

    public Documento(DocumentoDTO documentoDTO){
        this.id = documentoDTO.getId();
        this.capa = documentoDTO.getCapa();
        this.secoes = documentoDTO.getSecoes();
    }

    
}
