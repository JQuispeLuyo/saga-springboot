package com.ascencio.api_cuentas.repository;

import com.ascencio.api_cuentas.model.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends MongoRepository<Cuenta, String> {

    public Cuenta findByCliente(String cliente);

}
