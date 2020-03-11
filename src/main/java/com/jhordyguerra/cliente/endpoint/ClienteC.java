package com.jhordyguerra.cliente.endpoint;

import com.jhordyguerra.cliente.model.ClienteM;
import com.jhordyguerra.cliente.repository.ClienteR;
import com.jhordyguerra.cliente.service.ClienteS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@RestController
@RequestMapping(value = "cliente")
public class ClienteC {
    @Autowired
    ClienteR repository;

    @GetMapping(value = "lista/")
    public Object list() {
        return repository.findAll();
    }

    @GetMapping(value = "lista/{dni}")
    public Object list(@PathVariable String dni) {
        return repository.findByDniStartsWith(dni);
    }

    @PostMapping(value = "crear")
    public Object create(@RequestBody ClienteM body) {
        return repository.save(body);
    }
    @PostMapping(value = "rollBack/{dni}")
    public Object rollBack(@RequestBody ClienteM body) {
        return repository.save(body);
    }
    @Autowired
    private ClienteS clienteS;

    @Bean
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }
}
