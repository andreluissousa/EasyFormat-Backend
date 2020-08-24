package br.com.easyformat.service.implementation;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.easyformat.domain.entity.Citacao;
import br.com.easyformat.domain.repository.AutorRepository;
import br.com.easyformat.domain.repository.CitacaoRepository;
import br.com.easyformat.rest.dto.CitacaoDTO;
import br.com.easyformat.service.CitacaoService;
import br.com.easyformat.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitacaoServiceImpl implements CitacaoService {

    @Autowired
    private CitacaoRepository citacaoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Citacao> buscarTodos() {
        return citacaoRepository.findAll();
    }

    @Override
    public Citacao salvarCitacao(Citacao citacao) {
        return citacaoRepository.insert(citacao);
    }

    @Override
    public Citacao fromDTO(CitacaoDTO citacaoDTO) {
        return new Citacao(citacaoDTO);
    }

    @Override
    public Citacao buscarPorId(String id) {
        Optional<Citacao> citacao = citacaoRepository.findById(id);
        return citacao.orElseThrow(() -> new ObjectNotFoundException("Citação não encontrada"));
    }

    @Override
    public void delete(String id) {
        buscarPorId(id);
        citacaoRepository.deleteById(id);
    }
    @Override
    public Citacao update( Citacao citacao) {
        Citacao novaCitacao = buscarPorId(citacao.getId());
        atualizaDados(citacao, novaCitacao);
        autorRepository.save(novaCitacao.getAutor());
        return citacaoRepository.save(novaCitacao);
    }

    public void atualizaDados(Citacao citacao, Citacao novaCitacao) {
        novaCitacao.setTexto(citacao.getTexto());
        novaCitacao.setAutor(citacao.getAutor());
    }

    
}