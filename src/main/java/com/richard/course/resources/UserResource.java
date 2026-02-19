package com.richard.course.resources;

import com.richard.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//A classe vira um recurso web REST
@RestController
//precisa de um nome!
@RequestMapping(value = "/users") // "rota"
public class UserResource {

    @GetMapping //GET
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "999999", "12345");
        return ResponseEntity.ok().body(u); //diz que vai retornar 200 (OK) e que o corpo enviado sera a minha instancia
    }

}
