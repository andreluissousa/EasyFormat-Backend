package br.com.easyformat.service;

import java.util.List;
import br.com.easyformat.domain.entity.SubSecao;
import br.com.easyformat.rest.dto.SubSecaoDTO;

public interface SubSecaoService {
    
    List<SubSecao> buscarTodos();
    SubSecao buscarPorId(String id);
    SubSecao salvarSubSecao(SubSecao subSecao);
    SubSecao fromDTO(SubSecaoDTO subSecaoDTO);
    void delete(String id);
    SubSecao update(SubSecao subSecao);
}