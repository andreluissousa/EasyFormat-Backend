package br.com.easyformat.domain.repository;

import br.com.easyformat.domain.entity.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {


}
