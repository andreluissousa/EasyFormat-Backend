package br.com.easyformat.domain.repository;

import br.com.easyformat.domain.entity.Instituicao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends MongoRepository<Instituicao, String> {

}
