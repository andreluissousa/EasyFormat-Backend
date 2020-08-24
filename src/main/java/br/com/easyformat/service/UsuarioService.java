package br.com.easyformat.service;

import br.com.easyformat.domain.entity.Usuario;
import br.com.easyformat.rest.dto.UsuarioDTO;

public interface UsuarioService {
    
    Usuario salvarUsuario(Usuario usuario);
    Usuario fromDTO(UsuarioDTO usuarioDTO);
    Usuario buscarPorId(String id);
    void delete(String id);
    Usuario update(Usuario usuario);
}