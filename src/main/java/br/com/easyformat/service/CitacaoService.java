package br.com.easyformat.service;

import java.util.List;
import br.com.easyformat.domain.entity.Citacao;
import br.com.easyformat.rest.dto.CitacaoDTO;

public interface CitacaoService {
    
    List<Citacao> buscarTodos();
    Citacao salvarCitacao(Citacao citacao);
    Citacao fromDTO(CitacaoDTO citacaoDTO);
    Citacao buscarPorId(String id);
    void delete(String id);
    Citacao update(Citacao citacao);
    void atualizaDados(Citacao citacao, Citacao novaCitacao);
}