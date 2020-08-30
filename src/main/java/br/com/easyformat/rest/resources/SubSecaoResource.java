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
import br.com.easyformat.domain.entity.SubSecao;
import br.com.easyformat.rest.dto.SubSecaoDTO;
import br.com.easyformat.service.SubSecaoService;

@RestController
@RequestMapping("/api/subSecao")
public class SubSecaoResource {
    
    @Autowired
    private SubSecaoService subSecaoService;

    @GetMapping
    public ResponseEntity<List<SubSecao>> buscarTodos(){
        List<SubSecao> listaSubSecao = subSecaoService.buscarTodos();
        return ResponseEntity.ok().body(listaSubSecao);
    }

    @GetMapping("{id}")
    public ResponseEntity<SubSecao> buscarPorId(@PathVariable String id){
        SubSecao subSecao = subSecaoService.buscarPorId(id);
        return ResponseEntity.ok().body(subSecao);
    }

    @PostMapping
    public ResponseEntity<Void> salvarSubSecao(@RequestBody @Valid SubSecaoDTO subSecaoDTO){
        SubSecao subSecao = subSecaoService.fromDTO(subSecaoDTO);
        subSecaoService.salvarSubSecao(subSecao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(subSecao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        subSecaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid SubSecaoDTO subSecaoDTO, @PathVariable String id){
        SubSecao subSecao = subSecaoService.fromDTO(subSecaoDTO);
        subSecao.setId(id);
        subSecaoService.update(subSecao);
        return ResponseEntity.noContent().build();
    }
    
}