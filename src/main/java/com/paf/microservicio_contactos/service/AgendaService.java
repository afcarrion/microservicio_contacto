package com.paf.microservicio_contactos.service;

import com.paf.microservicio_contactos.model.Contacto;

import java.util.List;

public interface AgendaService {

    boolean agregarContacto(Contacto contacto);

    List<Contacto> recuperarContactos();

    void actualizarContacto(Contacto contacto);

    boolean eliminarContacto(int idContacto);

    Contacto buscarContacto(int idContacto);

}
