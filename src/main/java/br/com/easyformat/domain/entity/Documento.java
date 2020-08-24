package br.com.easyformat.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
@NoArgsConstructor
public class Documento {

    @Id
    private String id;

    private String nomeArquivo;

    private String diretorioDocumento;

    private Capa capa;

    private List<Secao> secoes = new ArrayList<>();

    public Documento(String id, String nomeArquivo, String diretorioDocumento, Capa capa) {
        this.id = id;
        this.nomeArquivo = nomeArquivo;
        this.diretorioDocumento = diretorioDocumento;
        this.capa = capa;
    }

    
}
