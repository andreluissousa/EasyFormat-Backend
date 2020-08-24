package br.com.easyformat.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.easyformat.domain.entity.Capa;
import br.com.easyformat.domain.repository.AutorRepository;
import br.com.easyformat.domain.repository.CapaRepository;
import br.com.easyformat.rest.dto.CapaDTO;
import br.com.easyformat.service.CapaService;
import br.com.easyformat.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CapaServiceImpl implements CapaService {

    @Autowired
    private CapaRepository capaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Capa salvarCapa(Capa capa) {
        return capaRepository.insert(capa);
    }

    @Override
    public Capa fromDTO(CapaDTO capaDTO) {
        return new Capa(capaDTO);
    }

    @Override
    public Capa buscarPorId(String id) {
        Optional<Capa> capa = capaRepository.findById(id);
        return capa.orElseThrow(() -> new ObjectNotFoundException("Capa não encontrada"));
    }

    @Override
    public void delete(String id) {
       buscarPorId(id);
       capaRepository.deleteById(id);
    }

    @Override
    public Capa update(Capa capa) {
        Capa novaCapa = buscarPorId(capa.getId());
        atualizaDados(novaCapa, capa);
        autorRepository.saveAll(novaCapa.getAutores());
        return capaRepository.save(novaCapa);
    }

    @Override
    public List<Capa> buscarTodos() {
       return capaRepository.findAll();
    }

    private void atualizaDados(Capa novaCapa, Capa capa){
        novaCapa.setTitulo(capa.getTitulo());
        novaCapa.setSubTitulo(capa.getSubTitulo());
        novaCapa.setAutores(capa.getAutores());
    }
    
}