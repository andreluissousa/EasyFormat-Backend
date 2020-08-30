package br.com.easyformat.rest.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import br.com.easyformat.domain.entity.Citacao;
import br.com.easyformat.domain.entity.Secao;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SecaoDTO {
    
    private String id;

    @NotEmpty(message = "{secao.titulo}")
    private String titulo;

    private Integer ordem;

    @NotEmpty(message = "{secao.conteudo}")
    private String conteuto;

    private String nomeImagem;

    private String diretorioImagem;

    private List<Citacao> citacao = new ArrayList<Citacao>();   

    public SecaoDTO(Secao secao){
        this.id = secao.getId();
        this.titulo = secao.getTitulo();
        this.ordem = secao.getOrdem();
        this.conteuto = secao.getConteudo();
        this.nomeImagem = secao.getNomeImagem();
        this.diretorioImagem = secao.getDiretorioImagem();
        this.citacao = secao.getCitacao();
    }
}