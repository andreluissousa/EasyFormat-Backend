package br.com.easyformat.rest.dto;

import javax.validation.constraints.NotEmpty;
import br.com.easyformat.domain.entity.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {
    
    private String id;

    @NotEmpty(message = "{nome}")
    private String nome;

    @NotEmpty(message = "{sobrenome}")
    private String sobrenome;

    @NotEmpty(message = "{usuario.email}")
    private String email;

    @NotEmpty(message = "{usuario.senha}")
    private String senha;

    @NotEmpty(message = "{usuario.fomacao}")
    private String formacao;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.formacao = usuario.getFormacao();
    }
    
}