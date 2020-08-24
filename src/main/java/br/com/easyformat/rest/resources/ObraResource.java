package br.com.easyformat.rest.resources;

import java.net.URI;
import java.util.List;
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
import br.com.easyformat.domain.entity.Obra;
import br.com.easyformat.service.ObraService;


@RestController
@RequestMapping("/api/obra")
public class ObraResource {
    
    @Autowired
    private ObraService obraService;

    @GetMapping
    public ResponseEntity<List<Obra>> buscarTodos(){
        List<Obra> listaObra = obraService.burcarTodos();
        return ResponseEntity.ok().body(listaObra);
    }

    @GetMapping("{id}")
    public ResponseEntity<Obra> buscarPorId(@PathVariable String id){
        Obra obra = obraService.buscarPorId(id);
        return ResponseEntity.ok().body(obra);
    }

    @PostMapping
    public ResponseEntity<Void> salvarObra(@RequestBody Obra obra){
        obraService.salvarObra(obra);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obra.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        obraService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update (@RequestBody Obra obra, @PathVariable String id){
        obra.setId(id);
        obraService.update(obra);
        return ResponseEntity.noContent().build();
    }
    
}