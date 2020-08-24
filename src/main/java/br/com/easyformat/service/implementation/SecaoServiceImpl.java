package br.com.easyformat.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.easyformat.domain.entity.Secao;
import br.com.easyformat.domain.repository.CitacaoRepository;
import br.com.easyformat.domain.repository.SecaoRepository;
import br.com.easyformat.domain.repository.SubSecaoRepository;
import br.com.easyformat.rest.dto.SecaoDTO;
import br.com.easyformat.service.SecaoService;
import br.com.easyformat.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecaoServiceImpl implements SecaoService {

    @Autowired
    private SecaoRepository secaoRepository;

    @Autowired
    private CitacaoRepository citacaoRepository;

    @Autowired
    private SubSecaoRepository subSecaoRepository;

    @Override
    public List<Secao> buscarTodos() {
        return secaoRepository.findAll();
    }

    @Override
    public Secao buscarPorId(String id) {
        Optional<Secao> secao = secaoRepository.findById(id);
        return secao.orElseThrow(() -> new ObjectNotFoundException("Seção não encontrada"));
    }

    @Override
    public Secao fromDTO(SecaoDTO secaoDTO) {
        return new Secao(secaoDTO);
    }

    @Override
    public void delete(String id) {
        buscarPorId(id);
        secaoRepository.deleteById(id);
    }

    @Override
    public Secao update(Secao secao) {
        Secao novaSecao = buscarPorId(secao.getId());
        atualizaDados(novaSecao, secao);
        citacaoRepository.saveAll(novaSecao.getCitacao()); 
        subSecaoRepository.saveAll(novaSecao.getSubSecao());       
        return secaoRepository.save(novaSecao);
    }

    private void atualizaDados(Secao novaSecao, Secao secao) {
        novaSecao.setTitulo(secao.getTitulo());
        novaSecao.setConteudo(secao.getConteudo());
        novaSecao.setNomeImagem(secao.getNomeImagem());
        novaSecao.setDiretorioImagem(secao.getDiretorioImagem());
        novaSecao.setOrdem(secao.getOrdem());
        novaSecao.setSubSecao(secao.getSubSecao());
        novaSecao.setCitacao(secao.getCitacao());
    }

    @Override
    public Secao salvarSecao(Secao secao) {
        return secaoRepository.insert(secao);        
    }
    
}