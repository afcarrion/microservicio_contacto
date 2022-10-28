package com.paf.microservicio_contactos.dao;

import com.paf.microservicio_contactos.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AgendaJPASpring extends JpaRepository<Contacto, Integer> {

    Contacto findByEmail(String email);

    @Transactional
    @Modifying
    @Query("delete from Contacto c where c.email=?1")
    void eliminarPorEmail(String email);
}
