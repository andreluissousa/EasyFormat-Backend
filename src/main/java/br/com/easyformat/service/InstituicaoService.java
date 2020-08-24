package br.com.easyformat.service;

import java.util.List;
import br.com.easyformat.domain.entity.Instituicao;
import br.com.easyformat.rest.dto.InstituicaoDTO;

public interface InstituicaoService {
    
    Instituicao salvarInstituicao(Instituicao instituicao);
    Instituicao fromDTO(InstituicaoDTO instituicaoDTO);
    List<Instituicao> buscarTodos();
    Instituicao buscarPorId(String id);
    void delete(String id);
    Instituicao update(Instituicao instituicao);
    
}