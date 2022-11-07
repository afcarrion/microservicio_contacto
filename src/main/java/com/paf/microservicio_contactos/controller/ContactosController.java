package com.paf.microservicio_contactos.controller;

import com.paf.microservicio_contactos.model.Contacto;
import com.paf.microservicio_contactos.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public List<Contacto> recuperarContactos(){
        return service.recuperarContactos();
    }

    @GetMapping(value = "contactos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Contacto recuperarContactos(@PathVariable("id") int id){
        return service.buscarContacto(id);
    }

    @PostMapping(value="contactos", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String guardarContacto(@RequestBody Contacto contacto){
        return String.valueOf(service.agregarContacto(contacto));
    }

    @PutMapping(value = "contactos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarContacto(@RequestBody Contacto contacto){
        service.actualizarContacto(contacto);
    }

    @DeleteMapping(value = "contactos/{id}")
    public void eliminarContacto(@PathVariable("id") int idContacto){
        service.eliminarContacto(idContacto);
    }

}
