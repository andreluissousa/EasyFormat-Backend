package br.com.easyformat.service;

import java.util.List;
import br.com.easyformat.domain.entity.Secao;
import br.com.easyformat.rest.dto.SecaoDTO;

public interface SecaoService {
    
    List<Secao> buscarTodos();
    Secao buscarPorId(String id);
    Secao salvarSecao(Secao secao);
    Secao fromDTO(SecaoDTO secaoDTO);
    void delete(String id);
    Secao update(Secao secao);
}