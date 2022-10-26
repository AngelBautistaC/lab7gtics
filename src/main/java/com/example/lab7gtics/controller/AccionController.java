package com.example.lab7gtics.controller;

import com.example.lab7gtics.entity.Accione;
import com.example.lab7gtics.entity.Solicitude;
import com.example.lab7gtics.repository.AccioneRepository;
import com.example.lab7gtics.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/acciones")

    public class AccionController {

        @Autowired
        AccioneRepository accioneRepository;

        @PostMapping("/guardar")
        public ResponseEntity<HashMap<String,String>> crearAccion(
                @RequestBody Accione accione
        ){

            HashMap<String,String> hashMap = new HashMap<>();
            //prueba
            accioneRepository.save(accione);
            hashMap.put("idCreado", String.valueOf(accione.getId()));



            return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
        }

    }
