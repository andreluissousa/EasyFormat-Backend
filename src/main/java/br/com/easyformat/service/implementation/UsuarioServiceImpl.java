package br.com.easyformat.service.implementation;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.easyformat.domain.entity.Usuario;
import br.com.easyformat.domain.repository.UsuarioRepository;
import br.com.easyformat.rest.dto.UsuarioDTO;
import br.com.easyformat.service.UsuarioService;
import br.com.easyformat.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.insert(usuario);
    }

    @Override
    public Usuario buscarPorId(String id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
    }

    @Override
    public void delete(String id) {
        buscarPorId(id);
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario update(Usuario usuario) {
        Usuario novoUsuario = buscarPorId(usuario.getId());
        atualizaDados(novoUsuario, usuario);
        return usuarioRepository.save(novoUsuario);
    }

    private void atualizaDados(Usuario novoUsuario, Usuario usuario) {
        novoUsuario.setNome(usuario.getNome());
        novoUsuario.setSobreNome(usuario.getSobreNome());
        novoUsuario.setEmail(usuario.getEmail());
        novoUsuario.setSenha(usuario.getSenha());
        novoUsuario.setFormacao(usuario.getFormacao());
        novoUsuario.setDataNascimento(usuario.getDataNascimento());
    }

    @Override
    public Usuario fromDTO(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO);
    }

   
       
}