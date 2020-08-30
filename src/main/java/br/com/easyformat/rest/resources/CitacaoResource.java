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
import br.com.easyformat.domain.entity.Citacao;
import br.com.easyformat.rest.dto.CitacaoDTO;
import br.com.easyformat.service.CitacaoService;

@RestController
@RequestMapping("/api/citacao")
public class CitacaoResource {
    
    @Autowired
    private CitacaoService citacaoService;

    @GetMapping
    public ResponseEntity<List<Citacao>> buscarTodos(){
        List<Citacao> listaCitacao = citacaoService.buscarTodos();
        return ResponseEntity.ok().body(listaCitacao);
    }

    @GetMapping("{id}")
    public ResponseEntity<CitacaoDTO> buscarPorId(@PathVariable String id){
        Citacao citacao = citacaoService.buscarPorId(id);
        return ResponseEntity.ok().body(new CitacaoDTO(citacao));
    }

    @PostMapping
    public ResponseEntity<Void> salvarCitacao(@RequestBody @Valid CitacaoDTO citacaoDTO){
        Citacao citacao = citacaoService.fromDTO(citacaoDTO);
        citacaoService.salvarCitacao(citacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/{id}").buildAndExpand(citacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        citacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid CitacaoDTO citacaoDTO, @PathVariable String id){
        Citacao citacao = citacaoService.fromDTO(citacaoDTO);
        citacao.setId(id);
        citacaoService.update(citacao);
        return ResponseEntity.noContent().build();
    }

}