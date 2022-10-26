package com.example.lab7gtics.controller;

import com.example.lab7gtics.entity.Solicitude;
import com.example.lab7gtics.entity.Usuario;
import com.example.lab7gtics.repository.SolicitudRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/solicitudes")
public class SolicitudController {
    @Autowired
    SolicitudRepository solicitudRepository;

    @GetMapping("/listarUsers")
    public List<Solicitude> listarSolictudes(){
        return solicitudRepository.findAll();
    }
    @PostMapping("/registro")
    public ResponseEntity<HashMap<String,String>> crearSolicitud(
            @RequestBody Solicitude solicitude
            ){

        HashMap<String,String> hashMap = new HashMap<>();
       solicitude.setSolicitud_estado("pendiente");
        //prueba
        solicitudRepository.save(solicitude);
        hashMap.put("idCreado", String.valueOf(solicitude.getId()));
        hashMap.put("Monto", String.valueOf(solicitude.getSolicitud_monto()));


        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }


    @PostMapping("/aprobarSolicitud")
    public ResponseEntity<HashMap<String,String>> aprobarSolicitud(@RequestParam("idSolicitud") String id
    ){
        HashMap<String,String> hashMap = new HashMap<>();
        try {
            Optional<Solicitude> opt = solicitudRepository.findById(Integer.valueOf(id));
            if(opt.isPresent()){
                    Solicitude solicitude= opt.get();
                    if(solicitude.getSolicitud_estado().equals("pendiente")){
                        solicitude.setSolicitud_estado("aprobado");
                        solicitudRepository.save(solicitude);
                        hashMap.put("id solicitado",String.valueOf(solicitude.getId()));
                    }else {
                        hashMap.put("Solicitud ya antendida",String.valueOf(solicitude.getId()));
                    }
                return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);

            }else {
                hashMap.put("Aviso","El id ingresa no se encuentra");
                return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
            }
        }catch (NumberFormatException e){
            hashMap.put("error","el valor ingresado no es un numero");
            return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
        }



    }
}
