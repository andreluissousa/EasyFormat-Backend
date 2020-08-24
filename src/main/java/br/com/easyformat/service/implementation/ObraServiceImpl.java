package br.com.easyformat.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.easyformat.domain.entity.Obra;
import br.com.easyformat.domain.repository.ObraRepository;
import br.com.easyformat.rest.dto.ObraDTO;
import br.com.easyformat.service.ObraService;
import br.com.easyformat.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObraServiceImpl implements ObraService {

    @Autowired
    private ObraRepository obraRepository;

    @Override
    public List<Obra> burcarTodos() {
        return obraRepository.findAll();
    }

    @Override
    public Obra salvarObra(Obra obra) {
        return obraRepository.insert(obra);
    }

    @Override
    public Obra fromDTO(ObraDTO obraDTO) {
       return new Obra(obraDTO);
    }

    @Override
    public Obra buscarPorId(String id) {
        Optional<Obra> obra = obraRepository.findById(id);
        return obra.orElseThrow(() -> new ObjectNotFoundException("Obra não encontrada"));
    }

    @Override
    public void delete(String id) {
       buscarPorId(id);
       obraRepository.deleteById(id);
    }

    @Override
    public Obra update(Obra obra) {
        Obra novaObra = buscarPorId(obra.getId());
        atualizaDados(novaObra, obra);
        return obraRepository.save(novaObra);
    }

    private void atualizaDados(Obra novaObra, Obra obra){
        novaObra.setTitulo(obra.getTitulo());
        novaObra.setData(obra.getData());
        novaObra.setEditora(obra.getEditora());
        novaObra.setEdicao(obra.getEdicao());
        novaObra.setLocal(obra.getLocal());
    }
    
}