package br.com.easyformat.rest.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import br.com.easyformat.domain.entity.Curso;
import br.com.easyformat.domain.entity.Instituicao;
import br.com.easyformat.validation.NotEmptyList;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class InstituicaoDTO {
    
    private String id;
    @NotEmpty(message = "{instituicao.nome}")
    private String nome;
    @NotEmpty(message = "{instituicao.uf}")
    private String UF;
    @NotEmpty(message = "{instituicao.cidade}")
    private String cidade;
    @NotEmptyList
    private List<Curso> cursos = new ArrayList<Curso>();

    public InstituicaoDTO(Instituicao instituicao) {
        this.id = instituicao.getId();
        this.nome = instituicao.getNome();
        this.UF = instituicao.getUF();
        this.cidade = instituicao.getCidade();
        this.cursos = instituicao.getCursos();
    }

    
}