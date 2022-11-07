package com.paf.microservicio_contactos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.paf.microservicio_contactos.controller","com.paf.microservicio_contactos.dao","com.paf.microservicio_contactos.service"})
@EntityScan(basePackages = {"com.paf.microservicio_contactos.model"})
@EnableJpaRepositories(basePackages = {"com.paf.microservicio_contactos.dao"})
public class MicroservicioContactosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioContactosApplication.class, args);
    }

}
