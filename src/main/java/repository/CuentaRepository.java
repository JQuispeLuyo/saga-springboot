package repository;

import model.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends MongoRepository<Cuenta, String> {

}
