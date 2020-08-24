package br.com.easyformat.domain.repository;

import br.com.easyformat.domain.entity.Documento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends MongoRepository<Documento, String> {
    
}
