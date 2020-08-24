package br.com.easyformat.service.implementation;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.easyformat.domain.entity.Instituicao;
import br.com.easyformat.domain.repository.CursoRepository;
import br.com.easyformat.domain.repository.InstituicaoRepository;
import br.com.easyformat.rest.dto.InstituicaoDTO;
import br.com.easyformat.service.InstituicaoService;
import br.com.easyformat.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstituicaoServiceImpl implements InstituicaoService {

    @Autowired
    private InstituicaoRepository repository;

    @Autowired
    private CursoRepository cursoRepository;


    @Override
    public Instituicao salvarInstituicao(Instituicao instituicao) {
       
        return repository.insert(instituicao);
    }

    @Override
    public Instituicao fromDTO(InstituicaoDTO instituicaoDTO) {
        return new Instituicao(instituicaoDTO.getId(), instituicaoDTO.getNome(), instituicaoDTO.getUF(),
                instituicaoDTO.getCidade(), instituicaoDTO.getCursos());
    }

    @Override
    public List<Instituicao> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Instituicao buscarPorId(String id) {
        Optional<Instituicao> instituicao = repository.findById(id);
        return instituicao.orElseThrow(() -> new ObjectNotFoundException("Instituição não encontrada"));
    }

    @Override
    public void delete(String id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

    @Override
    public Instituicao update(Instituicao instituicao) {
        Instituicao novaInstituicao = buscarPorId(instituicao.getId());
        atualizaDados(novaInstituicao, instituicao);
        cursoRepository.saveAll(novaInstituicao.getCursos());
        return repository.save(novaInstituicao);
    }

    private void atualizaDados(Instituicao novaInstituicao, Instituicao instituicao) {
        novaInstituicao.setNome(instituicao.getNome());
        novaInstituicao.setUF(instituicao.getUF());
        novaInstituicao.setCidade(instituicao.getCidade());
        novaInstituicao.setCursos(instituicao.getCursos());
    }


}