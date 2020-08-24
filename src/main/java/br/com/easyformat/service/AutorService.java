package br.com.easyformat.service;

import java.util.List;
import br.com.easyformat.domain.entity.Autor;
import br.com.easyformat.rest.dto.AutorDTO;

public interface AutorService {
    
    List<Autor> buscarTodos();
    Autor salvarAutor(Autor autor);
    Autor fromDTO(AutorDTO autorDTO);
    Autor buscarPorId(String id);
    void delete(String id);
    Autor update(Autor autor);
}