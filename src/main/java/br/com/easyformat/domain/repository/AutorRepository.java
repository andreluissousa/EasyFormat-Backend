package br.com.easyformat.domain.repository;

import br.com.easyformat.domain.entity.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends MongoRepository<Autor, String> {
}
