package com.paf.microservicio_contactos.service;

import com.paf.microservicio_contactos.dao.AgendaDao;
import com.paf.microservicio_contactos.model.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService{

    @Autowired
    AgendaDao dao;

    @Override
    public boolean agregarContacto(Contacto contacto) {
        if(dao.recuperarContacto(contacto.getId())==null){
            dao.agregarContacto(contacto);
            return true;
        }
        return false;
    }

    @Override
    public List<Contacto> recuperarContactos() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dao.devolverContactos();
    }

    @Override
    public boolean actualizarContacto(Contacto contacto) {
        if(dao.recuperarContacto(contacto.getId())!=null){
            dao.actualizarContacto(contacto);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarContacto(int idContacto) {
        if(dao.recuperarContacto(idContacto)!=null){
            dao.eliminarContacto(idContacto);
            return true;
        }
        return false;
    }

    @Override
    public Contacto buscarContacto(int idContacto) {
        return dao.recuperarContacto(idContacto);
    }
}
