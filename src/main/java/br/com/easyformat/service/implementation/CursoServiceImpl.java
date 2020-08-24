package br.com.easyformat.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.com.easyformat.domain.entity.Curso;
import br.com.easyformat.domain.repository.CursoRepository;
import br.com.easyformat.rest.dto.CursoDTO;
import br.com.easyformat.service.CursoService;
import br.com.easyformat.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private CursoRepository repository;


    @Override
    public Curso salvarCurso(Curso curso) {
        return repository.insert(curso);
    }

    @Override
    public Curso fromDTO(CursoDTO cursoDTO) {
        return new Curso(cursoDTO.getId(), cursoDTO.getNome());
    }

    @Override
    public List<Curso> burcarTodos() {
        return repository.findAll();
    }

    @Override
    public Curso buscarPorId(String id) {
        Optional<Curso> curso = repository.findById(id);
        return curso.orElseThrow(() -> new ObjectNotFoundException("Curso não encontrado"));
    }

    @Override
    public void delete(String id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

    @Override
    public Curso atualizar(Curso curso) {
        Curso novoCurso = buscarPorId(curso.getId());
        atualizaDados(curso, novoCurso);
        return repository.save(novoCurso);
    }

    private void atualizaDados(Curso curso, Curso novoCurso){
        novoCurso.setNome(curso.getNome());
    }

  
}