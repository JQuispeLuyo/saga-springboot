package com.jhordyguerra.cliente.repository;

import com.jhordyguerra.cliente.model.ClienteM;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ClienteR extends MongoRepository<ClienteM, String> {
    ClienteM findByDniStartsWith(String code);
}
