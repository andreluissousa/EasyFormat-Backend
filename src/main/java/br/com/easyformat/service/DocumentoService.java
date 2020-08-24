package br.com.easyformat.service;

import java.util.List;
import br.com.easyformat.domain.entity.Documento;


public interface DocumentoService {
    
    Documento salvarDocumento(Documento documento);
    List<Documento> buscarTodos();
    Documento buscarPorId(String id);
    void delete(String id);
    Documento atualizar(Documento documento);
}