package br.com.easyformat.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.easyformat.domain.entity.SubSecao;
import br.com.easyformat.domain.repository.CitacaoRepository;
import br.com.easyformat.domain.repository.SubSecaoRepository;
import br.com.easyformat.rest.dto.SubSecaoDTO;
import br.com.easyformat.service.SubSecaoService;
import br.com.easyformat.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubSecaoServiceImpl implements SubSecaoService {

    @Autowired
    private SubSecaoRepository subSecaoRepository;

    @Autowired
    private CitacaoRepository citacaoRepository;

    @Override
    public List<SubSecao> buscarTodos() {
        return subSecaoRepository.findAll();
    }

    @Override
    public SubSecao buscarPorId(String id) {
        Optional<SubSecao> subSecao = subSecaoRepository.findById(id);
        return subSecao.orElseThrow( () -> new ObjectNotFoundException("SubSeção não encontrada"));
    }

    @Override
    public SubSecao salvarSubSecao(SubSecao subSecao) {
        return subSecaoRepository.insert(subSecao);
    }

    @Override
    public SubSecao fromDTO(SubSecaoDTO subSecaoDTO) {
        return new SubSecao(subSecaoDTO);
    }

    @Override
    public void delete(String id) {
        buscarPorId(id);
        subSecaoRepository.deleteById(id);
    }

    @Override
    public SubSecao update(SubSecao subSecao) {
        SubSecao novaSubSecao = buscarPorId(subSecao.getId());
        autualizaDados(novaSubSecao, subSecao);
        citacaoRepository.saveAll(novaSubSecao.getCitacao());
        subSecaoRepository.saveAll(novaSubSecao.getSubSecao());
        return subSecaoRepository.save(novaSubSecao);
    }

    private void autualizaDados(SubSecao novaSubSecao, SubSecao subSecao){
        novaSubSecao.setTitulo(subSecao.getTitulo());
        novaSubSecao.setConteudo(subSecao.getConteudo());
        novaSubSecao.setNomeImagem(subSecao.getNomeImagem());
        novaSubSecao.setDiretorioImagem(subSecao.getDiretorioImagem());
        novaSubSecao.setOrdem(subSecao.getOrdem());
        novaSubSecao.setSubSecao(subSecao.getSubSecao());
        novaSubSecao.setCitacao(subSecao.getCitacao());
    }
    
}