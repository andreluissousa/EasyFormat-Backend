package br.com.easyformat.service;

import java.util.List;

import br.com.easyformat.domain.entity.Curso;
import br.com.easyformat.rest.dto.CursoDTO;


public interface CursoService {

    Curso salvarCurso(Curso curso);
    Curso fromDTO(CursoDTO cursoDTO);
    List<Curso> burcarTodos();
    Curso buscarPorId(String id);
    void delete(String id);
    Curso atualizar(Curso curso);
    
}