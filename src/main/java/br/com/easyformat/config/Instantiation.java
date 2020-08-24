package br.com.easyformat.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import br.com.easyformat.domain.entity.Autor;
import br.com.easyformat.domain.entity.Capa;
import br.com.easyformat.domain.entity.Curso;
import br.com.easyformat.domain.entity.Documento;
import br.com.easyformat.domain.entity.Instituicao;
import br.com.easyformat.domain.entity.Obra;
import br.com.easyformat.domain.entity.Secao;
import br.com.easyformat.domain.entity.SubSecao;
import br.com.easyformat.domain.repository.AutorRepository;
import br.com.easyformat.domain.repository.CapaRepository;
import br.com.easyformat.domain.repository.CitacaoRepository;
import br.com.easyformat.domain.repository.CursoRepository;
import br.com.easyformat.domain.repository.DocumentoRepository;
import br.com.easyformat.domain.repository.InstituicaoRepository;
import br.com.easyformat.domain.repository.ObraRepository;
import br.com.easyformat.domain.repository.SecaoRepository;
import br.com.easyformat.domain.repository.SubSecaoRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
    
    @Autowired
    private InstituicaoRepository instituicaoRepository;
    
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private SecaoRepository secaoRepository;

    @Autowired
    private CapaRepository capaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    private CitacaoRepository citacaoRepository;

    @Autowired
    private SubSecaoRepository subSecaoRepository;

    public void run(String... args) throws Exception{

       cursoRepository.deleteAll();
        instituicaoRepository.deleteAll();
        documentoRepository.deleteAll();
        documentoRepository.deleteAll();
        secaoRepository.deleteAll();
        capaRepository.deleteAll();
        autorRepository.deleteAll();
        obraRepository.deleteAll();
        citacaoRepository.deleteAll();
        subSecaoRepository.deleteAll();


        //Esta Classe é responsável por carregar o banco de dados, inserindo usuario, autores, documento e obras.

        
        Curso c1 = new Curso(null, "Análise e Desenvolvimento de Sistemas");
        Curso c2 = new Curso(null, "Banco de Dados");

        cursoRepository.saveAll(Arrays.asList(c1, c2));

        Instituicao instituicao = new Instituicao(null, "Estácio", "GO", "Anápolis");

        instituicao.getCursos().addAll(Arrays.asList(c1, c2));        

        instituicaoRepository.saveAll(Arrays.asList(instituicao));

        Obra obra1 = new Obra(null, "2017-05-25", "GN1", "Uma alternativa mais eficiente comparada aos sistemas WYSIWYG", 1, "Belo Horizonte MG");
        Obra obra2 = new Obra(null, "2015-04-30", "CUBO", "Numero de brasileiros com graduação cresce 109% em 10 anos", 2, "São Paulo SP");

        obraRepository.saveAll(Arrays.asList(obra1, obra2));

        Autor autor1 = new Autor();
        autor1.setNome("André Luiz");
        autor1.setSobreNome("Sousa Borges");
        autor1.setFormacao("Técnico em Informática para Internet");

        Capa capa = new Capa(null, "Interfáce gráfica Easyformat", "Trabalho de Conclusão de curso da turma de Técnico em Informática para Internet");

        capaRepository.save(capa);

        Autor autor2 = new Autor();
        autor2.setNome("Eduardo");
        autor2.setSobreNome("Nascimento");
        autor2.setFormacao("Técnico em Informática para Internet");
        
        Autor autor3 = new Autor();
        autor3.setNome("Jessen");
        autor3.setSobreNome("K. S.");

        autor3.getObras().addAll(Arrays.asList(obra1));

        autorRepository.saveAll(Arrays.asList(autor1, autor2, autor3));

        capa.getAutores().addAll(Arrays.asList(autor1, autor2));

        Secao secao1 = new Secao(null, "Titulo da seção 1", 1, "Conteudo da seção 1");
        Secao secao2 = new Secao(null, "Titulo da seção 2", 2, "Conteudo da seção 2");
        Secao secao3 = new Secao(null, "Titulo da seção 3", 3, "Conteudo da seção 3");
        SubSecao subSecao1 = new SubSecao(null, "Titulo da SubSeção 1", 1, "Conteudo da SubSeção 1");
        SubSecao subSecao2 = new SubSecao(null, "Titulo da SubSeção 2", 2, "Conteudo da SubSeção 2");
        SubSecao subSecao3 = new SubSecao(null, "titulo da subsecao 3", 3, "conteudo da subsecao 3");
        SubSecao subSecao4 = new SubSecao(null, "titulo da subsecao da subsecao", 1, "Conteudo da subsecao da subsecao");
        SubSecao subSecao5 = new SubSecao(null, "Titulo da da sub 5 ", 3, "conteudo da sub 5");
        SubSecao subSecao6 = new SubSecao(null, "Titulo da 6", 1, "conteudo");

        subSecaoRepository.saveAll(Arrays.asList(subSecao1, subSecao2, subSecao3, subSecao4, subSecao5, subSecao6));

        subSecao2.getSubSecao().addAll(Arrays.asList(subSecao4, subSecao5));

        subSecao5.getSubSecao().addAll(Arrays.asList(subSecao6));

        secao1.getSubSecao().addAll(Arrays.asList(subSecao1));

        secao3.getSubSecao().addAll(Arrays.asList(subSecao1, subSecao2));  

        secaoRepository.saveAll(Arrays.asList(secao1, secao2, secao3));

        secao3.getSubSecao().addAll(Arrays.asList(subSecao3));

        secaoRepository.saveAll(Arrays.asList(secao3));
      
        Documento documento = new Documento(null, "Easyfomat", capa);

        documento.getSecoes().addAll(Arrays.asList(secao1, secao2, secao3));

        documentoRepository.saveAll(Arrays.asList(documento));
     
        
    }
}