package br.com.easyformat.domain.repository;


import br.com.easyformat.domain.entity.Secao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecaoRepository extends MongoRepository<Secao, String> {

}
