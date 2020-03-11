package controller;

import model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repository.CuentaRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CuentaC {

    @Autowired
    CuentaRepository cuentaRepository;

    @GetMapping(value = "/getAll")
    public List<Cuenta> getAllCunetas() {
        return cuentaRepository.findAll();
    }

    @PostMapping(value = "/create")
    public Cuenta createCuenta(@Valid @RequestBody Cuenta cuenta) {
       return cuentaRepository.save(cuenta);
    }

}
