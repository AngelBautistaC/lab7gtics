package com.example.lab7gtics.controller;

import com.example.lab7gtics.entity.Pago;
import com.example.lab7gtics.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pagos")
public class PagoController {
    @Autowired
    PagoRepository pagoRepository;

    @GetMapping("/listarPagos")
    public List<Pago> listaUsuarios() {
        return pagoRepository.listaPagos();
    }

}
