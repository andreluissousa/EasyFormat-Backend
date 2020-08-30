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
import br.com.easyformat.domain.entity.Capa;
import br.com.easyformat.rest.dto.CapaDTO;
import br.com.easyformat.service.CapaService;

@RestController
@RequestMapping("/api/capa")
public class CapaResource {
    
    @Autowired
    private CapaService capaService;

    @GetMapping
    public ResponseEntity<List<Capa>> buscarTodos(){
         List<Capa> listaCapa = capaService.buscarTodos();
         return ResponseEntity.ok().body(listaCapa);
    }

    @GetMapping("{id}")
    public ResponseEntity<CapaDTO> buscarPorId(@PathVariable String id){
        Capa capa = capaService.buscarPorId(id);
        return ResponseEntity.ok().body(new CapaDTO(capa));
    }

    @PostMapping
    public ResponseEntity<Void> salvarCapa(@RequestBody @Valid CapaDTO capaDTO){
        Capa capa = capaService.fromDTO(capaDTO);
        capaService.salvarCapa(capa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(capa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        capaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update (@RequestBody @Valid CapaDTO capaDTO, @PathVariable String id){
        Capa capa = capaService.fromDTO(capaDTO);
        capa.setId(id);
        capaService.update(capa);
        return ResponseEntity.noContent().build();
    }
}