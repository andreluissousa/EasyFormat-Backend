package br.com.easyformat.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.easyformat.rest.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends Pessoa{

    @Id
    private String id;

    private String email;

    private String senha;

    @DBRef(lazy = true)
    private List<Documento> documentos = new ArrayList<>();

    public Usuario(UsuarioDTO usuarioDTO) {
        this.id = usuarioDTO.getId();
        this.setNome(usuarioDTO.getNome());
        this.setSobrenome(usuarioDTO.getSobrenome());
        this.setFormacao(usuarioDTO.getFormacao());
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
    }

    
}
