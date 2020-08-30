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

import br.com.easyformat.domain.entity.Curso;
import br.com.easyformat.rest.dto.CursoDTO;
import br.com.easyformat.service.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> buscarTodos(){
        List<Curso> listaCursos = cursoService.burcarTodos();
        return ResponseEntity.ok().body(listaCursos);
    }

    @GetMapping("{id}")
    public ResponseEntity<CursoDTO> buscarPorId(@PathVariable String id){
        Curso curso = cursoService.buscarPorId(id);
        return ResponseEntity.ok().body(new CursoDTO(curso));
    }

    @PostMapping
    public ResponseEntity<Void> salvarCurso(@RequestBody @Valid CursoDTO cursoDTO){
        Curso curso = cursoService.fromDTO(cursoDTO);
        cursoService.salvarCurso(curso);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update (@RequestBody @Valid CursoDTO cursoDTO, @PathVariable String id){
        Curso curso = cursoService.fromDTO(cursoDTO);
        curso.setId(id);
        cursoService.atualizar(curso);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}