package br.com.easyformat.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.easyformat.rest.dto.CapaDTO;

@Document
@Data
@NoArgsConstructor
public class Capa {

    @Id
    private String id;

    @NotEmpty(message = "O titulo é obrigatório")
    private String titulo;

    @NotEmpty(message = "O subtitulo é obrigatório")
    private String subTitulo;

    private List<Autor> autores = new ArrayList<>();

    public Capa(String id, String titulo, String sutTitulo) {
        this.id = id;
        this.titulo = titulo;
        this.subTitulo = sutTitulo;
    }

    public Capa(CapaDTO capaDTO){
        this.id = capaDTO.getId();
        this.titulo = capaDTO.getTitulo();
        this.subTitulo = capaDTO.getSubTitulo();
    }

}
