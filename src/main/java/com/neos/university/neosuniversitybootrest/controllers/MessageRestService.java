package com.neos.university.neosuniversitybootrest.controllers;

import com.neos.university.neosuniversitybootrest.domain.Information;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageRestService {

    @GetMapping("/greetings")
    public Information processMessage(
            @RequestParam(defaultValue = "Desconocido", required = false)String name){

        return new Information("Hola "+name + " bienvenido a Spring Boot 2.x- RestService");
    }

}
