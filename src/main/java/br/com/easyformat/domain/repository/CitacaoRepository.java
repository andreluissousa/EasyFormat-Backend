package br.com.easyformat.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.easyformat.domain.entity.Citacao;

@Repository
public interface CitacaoRepository extends MongoRepository<Citacao, String> {
    
}