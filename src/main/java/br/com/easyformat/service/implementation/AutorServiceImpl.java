package br.com.easyformat.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.easyformat.domain.entity.Autor;
import br.com.easyformat.domain.repository.AutorRepository;
import br.com.easyformat.domain.repository.ObraRepository;
import br.com.easyformat.rest.dto.AutorDTO;
import br.com.easyformat.service.AutorService;
import br.com.easyformat.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ObraRepository obraRepository;

    @Override
    public List<Autor> buscarTodos() {        
        return autorRepository.findAll();
    }

    @Override
    public Autor salvarAutor(Autor autor) {
        return autorRepository.insert(autor);
    }

    @Override
    public Autor fromDTO(AutorDTO autorDTO) {
        return new Autor(autorDTO);
    }

    @Override
    public Autor buscarPorId(String id) {
       Optional<Autor> autor = autorRepository.findById(id);
       return autor.orElseThrow(() -> new ObjectNotFoundException("Autor não encontrado"));
    }

    @Override
    public void delete(String id) {
        buscarPorId(id);
        autorRepository.deleteById(id);
    }

    @Override
    public Autor update(Autor autor) {
        Autor novoAutor = buscarPorId(autor.getId());
        atualizaDados(novoAutor, autor);   
        obraRepository.saveAll(novoAutor.getObras());     
        return autorRepository.save(novoAutor);
    }

    private void atualizaDados(Autor novoAutor, Autor autor){
        novoAutor.setNome(autor.getNome());
        novoAutor.setSobrenome(autor.getSobrenome());
        novoAutor.setObras(autor.getObras());
    }

}