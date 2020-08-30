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
import br.com.easyformat.domain.entity.Secao;
import br.com.easyformat.rest.dto.SecaoDTO;
import br.com.easyformat.service.SecaoService;

@RestController
@RequestMapping("/api/secao")
public class SecaoResource {
    
    @Autowired
    private SecaoService secaoService;

    @GetMapping
    public ResponseEntity<List<Secao>> buscarTodos(){
        List<Secao> listaSecao = secaoService.buscarTodos();
        return ResponseEntity.ok().body(listaSecao);
    }

    @GetMapping("{id}")
    public ResponseEntity<Secao> buscarPorId(@PathVariable String id){
        Secao secao = secaoService.buscarPorId(id);
        return ResponseEntity.ok().body(secao);
    }

    @PostMapping
    public ResponseEntity<Void> salvarSecao (@RequestBody @Valid SecaoDTO secaoDTO){
        Secao secao = secaoService.fromDTO(secaoDTO);
        secaoService.salvarSecao(secao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(secao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        secaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid SecaoDTO secaoDTO, @PathVariable String id){
        Secao secao = secaoService.fromDTO(secaoDTO);
        secao.setId(id);
        secaoService.update(secao);
        return ResponseEntity.noContent().build();
    }
}