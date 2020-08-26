package br.com.easyformat.rest.dto;

import javax.validation.constraints.NotEmpty;
import br.com.easyformat.domain.entity.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {
    
    private String id;

    @NotEmpty(message = "O nome é obrigatório")
    private String nome;

    @NotEmpty(message = "O sobrenome é obrigatório")
    private String sobrenome;

    @NotEmpty(message = "O email é obrigatório")
    private String email;

    @NotEmpty(message = "A senha é obrigatória")
    private String senha;

    @NotEmpty(message = "Por favor, informe a sua formação")
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