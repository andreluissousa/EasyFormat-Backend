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
import br.com.easyformat.domain.entity.Autor;
import br.com.easyformat.rest.dto.AutorDTO;
import br.com.easyformat.service.AutorService;

@RestController
@RequestMapping("/api/autor")
public class AutorResource {
    
    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> buscarTodos(){
        List<Autor> listaAutor = autorService.buscarTodos();
        return ResponseEntity.ok().body(listaAutor);
   }

   @GetMapping("{id}")
   public ResponseEntity<AutorDTO> buscarPorId(@PathVariable String id){
       Autor autor = autorService.buscarPorId(id);
       return ResponseEntity.ok().body(new AutorDTO(autor));
   }

   @PostMapping
   public ResponseEntity<Void> salvarAutor(@RequestBody AutorDTO autorDTO){
       Autor autor = autorService.fromDTO(autorDTO);
       autorService.salvarAutor(autor);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
       return ResponseEntity.created(uri).build();
   }
    
   @DeleteMapping("{id}")
   public ResponseEntity<Void> delete(@PathVariable String id){
       autorService.delete(id);
       return ResponseEntity.noContent().build();
   }

   @PutMapping("{id}")
   public ResponseEntity<Void> update (@RequestBody Autor autor, @PathVariable String id){
       autor.setId(id);
       autorService.update(autor);
       return ResponseEntity.noContent().build();
   }
}