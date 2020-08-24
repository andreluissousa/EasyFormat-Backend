package br.com.easyformat.service;

import java.util.List;

import br.com.easyformat.domain.entity.Capa;
import br.com.easyformat.rest.dto.CapaDTO;

public interface CapaService {
    
    List<Capa> buscarTodos();
    Capa salvarCapa(Capa capa);
    Capa fromDTO(CapaDTO capaDTO);
    Capa buscarPorId(String id);
    void delete(String id);
    Capa update(Capa capa);
}