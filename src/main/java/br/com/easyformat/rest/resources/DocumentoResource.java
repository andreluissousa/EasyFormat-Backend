package br.com.easyformat.rest.resources;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.easyformat.domain.entity.Documento;
import br.com.easyformat.service.DocumentoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoResource {
    
    @Autowired
    private DocumentoService documentoService;

    @GetMapping
    public ResponseEntity<List<Documento>> buscarTodos() {
        List<Documento> listaDocumentos = documentoService.buscarTodos();
        return ResponseEntity.ok().body(listaDocumentos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Documento> buscarPorId(@PathVariable String id){
        Documento documento = documentoService.buscarPorId(id);
        return ResponseEntity.ok().body(documento);
    }

    @PostMapping
    public ResponseEntity<Void> salvarDocumento(@RequestBody Documento documento){
        documentoService.salvarDocumento(documento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(documento.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }    

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        documentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update (@RequestBody Documento documento, @PathVariable String id){
        documento.setId(id);
        documentoService.atualizar(documento);
        return ResponseEntity.noContent().build();
    }
}