package br.com.easyformat.service;

import java.util.List;
import br.com.easyformat.domain.entity.Documento;
import br.com.easyformat.rest.dto.DocumentoDTO;

public interface DocumentoService {
    
    Documento salvarDocumento(Documento documento);
    List<Documento> buscarTodos();
    Documento buscarPorId(String id);
    void delete(String id);
    Documento fromDTO(DocumentoDTO documentoDTO);
    Documento atualizar(Documento documento);
}