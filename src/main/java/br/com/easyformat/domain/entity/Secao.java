package br.com.easyformat.domain.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.easyformat.rest.dto.SecaoDTO;

@Document
@Data
@NoArgsConstructor
public class Secao {

    @Id
    private String id;

    private String titulo;

    private Integer ordem;

    private String conteudo;

    private String nomeImagem;

    private List<Citacao> citacao = new ArrayList<Citacao>();

    private String diretorioImagem;

    private List<SubSecao> subSecao = new ArrayList<SubSecao>();

    public Secao(String id, String titulo, Integer ordem, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.ordem = ordem;
        this.conteudo = conteudo;
    }

    public Secao(SecaoDTO secaoDTO){
        this.titulo = secaoDTO.getTitulo();
        this.ordem = secaoDTO.getOrdem();
        this.conteudo = secaoDTO.getConteuto();
        this.nomeImagem = secaoDTO.getNomeImagem();
        this.diretorioImagem = secaoDTO.getDiretorioImagem();
    }

    
}
