package br.com.easyformat.rest.dto;

import java.util.ArrayList;
import java.util.List;
import br.com.easyformat.domain.entity.Curso;
import br.com.easyformat.domain.entity.Instituicao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class InstituicaoDTO {
    
    private String id;
    private String nome;
    private String UF;
    private String cidade;
    private List<Curso> cursos = new ArrayList<>();

    public InstituicaoDTO(Instituicao instituicao) {
        this.id = instituicao.getId();
        this.nome = instituicao.getNome();
        this.UF = instituicao.getUF();
        this.cidade = instituicao.getCidade();
        this.cursos = instituicao.getCursos();
    }

    
}