package br.com.easyformat.domain.repository;

import br.com.easyformat.domain.entity.Capa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapaRepository extends MongoRepository<Capa, String> {
}
