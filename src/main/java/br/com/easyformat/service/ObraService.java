package br.com.easyformat.service;

import java.util.List;
import br.com.easyformat.domain.entity.Obra;
import br.com.easyformat.rest.dto.ObraDTO;

public interface ObraService {
    
    List<Obra> burcarTodos();
    Obra salvarObra(Obra obra);
    Obra fromDTO(ObraDTO obraDTO);
    Obra buscarPorId(String id);
    void delete(String id);
    Obra update(Obra obra);
}