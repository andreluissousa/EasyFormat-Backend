package br.com.easyformat.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    private String id;

    @NotEmpty(message = "O nome do curso é obrigatório")
    private String nome;
    
    
}
