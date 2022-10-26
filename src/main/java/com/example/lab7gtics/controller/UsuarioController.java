package com.example.lab7gtics.controller;


import com.example.lab7gtics.entity.Usuario;
import com.example.lab7gtics.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("listar")
    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }
}
