package br.com.easyformat.rest.resources;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.easyformat.domain.entity.Usuario;
import br.com.easyformat.rest.dto.UsuarioDTO;
import br.com.easyformat.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos(){
        List<Usuario> listaUsuarios = usuarioService.buscarTodos();
        return ResponseEntity.ok().body(listaUsuarios);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable String id){
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok().body(new UsuarioDTO(usuario));
    }

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.fromDTO(usuarioDTO);
        usuario = usuarioService.salvarUsuario(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody UsuarioDTO usuarioDTO, @PathVariable String id){
        Usuario usuario = usuarioService.fromDTO(usuarioDTO);
        usuario.setId(id);
        usuario = usuarioService.update(usuario);
        return ResponseEntity.noContent().build();
    }
}