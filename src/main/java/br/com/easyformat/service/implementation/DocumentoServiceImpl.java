package br.com.easyformat.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.easyformat.domain.entity.Documento;
import br.com.easyformat.domain.repository.CapaRepository;
import br.com.easyformat.domain.repository.DocumentoRepository;
import br.com.easyformat.domain.repository.SecaoRepository;
import br.com.easyformat.rest.dto.DocumentoDTO;
import br.com.easyformat.service.DocumentoService;
import br.com.easyformat.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private CapaRepository capaRepository;

    @Autowired
    private SecaoRepository secaoRepository;

    // @Autowired
    // private SubSecaoRepository subSecaoRepository;

    @Override
    public Documento salvarDocumento(final Documento documento) {
        return documentoRepository.insert(documento);
    }

    @Override
    public List<Documento> buscarTodos() {
        return documentoRepository.findAll();
    }

    @Override
    public Documento buscarPorId(final String id) {
        final Optional<Documento> documento = documentoRepository.findById(id);
        return documento.orElseThrow(() -> new ObjectNotFoundException("Documento não encontrado"));
    }

    @Override
    public void delete(final String id) {
        buscarPorId(id);
        documentoRepository.deleteById(id);
    }

    @Override
    public Documento atualizar(final Documento documento) {
        final Documento novoDocumento = buscarPorId(documento.getId());
        atualizaDados(documento, novoDocumento);
        capaRepository.save(novoDocumento.getCapa());
        secaoRepository.saveAll(novoDocumento.getSecoes());
        return documentoRepository.save(novoDocumento);
    }

    private void atualizaDados(final Documento documento, final Documento novoDocumento) {
        novoDocumento.setNomeArquivo(documento.getNomeArquivo());
        novoDocumento.setCapa(documento.getCapa());
        novoDocumento.setSecoes(documento.getSecoes());
    }

    @Override
    public Documento fromDTO(DocumentoDTO documentoDTO) {
        return new Documento(documentoDTO);
    }

}