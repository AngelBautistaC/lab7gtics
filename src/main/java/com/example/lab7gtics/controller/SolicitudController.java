package com.example.lab7gtics.controller;

import com.example.lab7gtics.entity.Solicitude;
import com.example.lab7gtics.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/solicitudes")
public class SolicitudController {
    @Autowired
    SolicitudRepository solicitudRepository;

    @PostMapping("/registro")
    public ResponseEntity<HashMap<String,String>> crearSolicitud(
            @RequestBody Solicitude solicitude
            ){

        HashMap<String,String> hashMap = new HashMap<>();
        solicitudRepository.save(solicitude);
        hashMap.put("idCreado", String.valueOf(solicitude.getId()));



        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }
}