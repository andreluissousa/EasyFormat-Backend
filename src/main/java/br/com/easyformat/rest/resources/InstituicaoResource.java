package br.com.easyformat.rest.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
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
import br.com.easyformat.domain.entity.Instituicao;
import br.com.easyformat.rest.dto.InstituicaoDTO;
import br.com.easyformat.service.InstituicaoService;

@RestController
@RequestMapping("/api/instituicoes")
public class InstituicaoResource {
    
    @Autowired
    private InstituicaoService instituicaoService;

    @GetMapping
    public ResponseEntity<List<Instituicao>> buscarTodos(){
        List<Instituicao> listaInstituicao = instituicaoService.buscarTodos();
        listaInstituicao.stream().map( i -> new InstituicaoDTO(i)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaInstituicao);
    }

    @GetMapping("{id}")
    public ResponseEntity<InstituicaoDTO> buscarPorId(@PathVariable String id){
        Instituicao instituicao = instituicaoService.buscarPorId(id);
        return ResponseEntity.ok().body(new InstituicaoDTO(instituicao));
    }

    @PostMapping
    public ResponseEntity<Void> salvarInstituicao(@RequestBody InstituicaoDTO instituicaoDTO){
        Instituicao instituicao = instituicaoService.fromDTO(instituicaoDTO);
        
        instituicao = instituicaoService.salvarInstituicao(instituicao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(instituicao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        instituicaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody InstituicaoDTO instituicaoDTO, @PathVariable String id){
        Instituicao instituicao = instituicaoService.fromDTO(instituicaoDTO);
        instituicao.setId(id);
        instituicao = instituicaoService.update(instituicao);
        return ResponseEntity.noContent().build();
    }


}