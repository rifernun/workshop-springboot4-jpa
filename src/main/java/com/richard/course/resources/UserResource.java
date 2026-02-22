package com.richard.course.resources;

import com.richard.course.entities.User;
import com.richard.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//A classe vira um recurso web REST
@RestController
//precisa de um nome!
@RequestMapping(value = "/users") // "rota"
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping //GET
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list); //diz que vai retornar 200 (OK) e que o corpo enviado sera a minha instancia
    }

    @GetMapping(value = "/{id}") //url params
    //@PathVariable serve para pegar a variavel do url params
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id); //pega da classe service onde vai estar todos os tipos de execucoes e buscas
        return ResponseEntity.ok().body(obj); //200, {Corpo}
    }

    @PostMapping //method POST
    // @RequestBody pega o json que vai ser enviado!
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj); //created() precisa de um URI (endereco)
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
