package com.example.lab7gtics.controller;

import com.example.lab7gtics.entity.Pago;
import com.example.lab7gtics.entity.Usuario;
import com.example.lab7gtics.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pagos")
public class PagoController {
    @Autowired
    PagoRepository pagoRepository;

    @GetMapping("/listarPagos")
    public List<Pago> listaUsuarios() {
        return pagoRepository.findAll();
    }


    @PostMapping("/registrarPago")
    public ResponseEntity<HashMap<String,Object>> registrarPago(
            @RequestBody Pago pago,
            @RequestParam(value = "fetchId", required = false)boolean fetchId){
        HashMap<String,Object> hashMap = new HashMap<>();

        pagoRepository.save(pago);
        if(fetchId) {
            hashMap.put("id", String.valueOf(pago.getId()));
        }
        hashMap.put("id",String.valueOf(pago.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> gestionarErrorRegistrarPago(HttpServletRequest request){
        HashMap<String,String> hashMap = new HashMap<>();
        if(request.getMethod().equals("POST")){
            hashMap.put("error","true");
            hashMap.put("msg","Debes enviar el pago como json");
        }
        return ResponseEntity.badRequest().body(hashMap);
    }

}
