package com.ascencio.api_cuentas.controller;

import com.ascencio.api_cuentas.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ascencio.api_cuentas.repository.CuentaRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CuentaC {

    @Autowired
    CuentaRepository cuentaRepository;

    @GetMapping("/getAll")
    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    @PostMapping(value = "/create")
    public Cuenta createCuenta(@Valid @RequestBody Cuenta cuenta) {
       return cuentaRepository.save(cuenta);
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

}
