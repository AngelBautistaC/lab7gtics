package com.example.lab7gtics.controller;


import com.example.lab7gtics.entity.Usuario;
import com.example.lab7gtics.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/listar")
    public List<Usuario> listaUsuarios() {
        return usuarioRepository.listaUsers();
    }

    @PostMapping("/crear")
    public ResponseEntity<HashMap<String,String>> crearUsuario(@RequestBody Usuario usuario){
        HashMap<String,String> hashMap = new HashMap<>();

        usuarioRepository.save(usuario);

        hashMap.put("idCreado", String.valueOf(usuario.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> gestionarErrorCrearProducto(){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("error","true");
        hashMap.put("msg","Debes enviar el usuario como json");
        return ResponseEntity.badRequest().body(hashMap);
    }
}
