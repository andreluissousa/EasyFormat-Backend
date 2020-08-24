package br.com.easyformat.rest.dto;

import java.util.Date;
import br.com.easyformat.domain.entity.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {
    
    private String id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String formacao;
    private Date dataNascimento;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobreNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.formacao = usuario.getFormacao();
        this.dataNascimento = usuario.getDataNascimento();
    }

    
}