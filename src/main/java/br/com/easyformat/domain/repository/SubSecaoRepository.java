package br.com.easyformat.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.easyformat.domain.entity.SubSecao;

@Repository
public interface SubSecaoRepository extends MongoRepository<SubSecao, String>{
    
}