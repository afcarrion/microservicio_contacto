package com.paf.microservicio_contactos.controller;

import com.paf.microservicio_contactos.model.Contacto;
import com.paf.microservicio_contactos.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class ContactosController {

    @Autowired
    AgendaService service;

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String recup(){
        return "Hola Mundo";
    }

    @GetMapping(value="contactos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contacto>> recuperarContactos(){
        List<Contacto> contactos = service.recuperarContactos();
        HttpHeaders headers = new HttpHeaders();
        headers.add("total",String.valueOf(contactos.size()));
        return new ResponseEntity<List<Contacto>>(contactos,headers, HttpStatus.OK);
    }

    @GetMapping(value = "contactos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contacto> recuperarContactos(@PathVariable("id") int id){
        return new ResponseEntity<Contacto>(service.buscarContacto(id),HttpStatus.OK);
    }

    @PostMapping(value="contactos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> guardarContacto(@RequestBody Contacto contacto){
        if(service.agregarContacto(contacto)){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else{
            return  new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "contactos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> actualizarContacto(@RequestBody Contacto contacto){
        if(service.actualizarContacto(contacto)){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else{
            return  new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "contactos/{id}")
    public ResponseEntity<Void> eliminarContacto(@PathVariable("id") int idContacto){
        if(service.eliminarContacto(idContacto)){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else{
            return  new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

}
