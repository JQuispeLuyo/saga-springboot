package com.ascencio.api_cuentas.controller;

import com.ascencio.api_cuentas.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ascencio.api_cuentas.repository.CuentaRepository;

import javax.validation.Valid;
import java.util.List;

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

    /*@GetMapping("/getcuenta/{id_cliente}")
    public List<Cuenta> findById_cliente(@PathVariable String idCliente) {
        return cuentaRepository.findById_cliente(idCliente);
    }*/

}
