package com.ascencio.api_cuentas.controller;

import com.ascencio.api_cuentas.model.ActualizarSaldoDTO;
import com.ascencio.api_cuentas.model.Cuenta;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.ascencio.api_cuentas.repository.CuentaRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
@RestController
@RequestMapping("/api")
public class CuentaC {

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    private KafkaTemplate<String, String> template;

    @KafkaListener @KafkaListener(topics = "cuentaservice")
    public void listen1(String foo) {
        ActualizarSaldoDTO actualizarSaldoDTO = new ActualizarSaldoDTO();

        System.out.printf("Memsaje :"+ foo);
    }

}

    @PostMapping("/getcuenta/{cliente}/{monto}")
    public String findByCliente(@PathVariable String cliente,@PathVariable Double monto) {
        Cuenta cuenta = new Cuenta();
        cuenta = cuentaRepository.findByCliente(cliente);

        if(!(cuenta.getSaldo() <= monto)){
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            cuentaRepository.save(cuenta);
            return "Saldo correcto";
        }
        return "Saldo Insuficiente";
    }



    @GetMapping("/getAll")
    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    @PostMapping(value = "/create")
    public Cuenta createCuenta(@Valid @RequestBody Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

}
