package br.com.easyformat.domain.entity;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.easyformat.rest.dto.CitacaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Citacao {
    
    @Id
    private String id;

    @NotEmpty(message = "A citação deve conter algum texto")
    private String texto;
    

    private Autor autor;

    public Citacao(CitacaoDTO citacaoDTO){
        this.id = citacaoDTO.getId();
        this.texto = citacaoDTO.getTexto();
        this.autor = citacaoDTO.getAutor();
    }
}