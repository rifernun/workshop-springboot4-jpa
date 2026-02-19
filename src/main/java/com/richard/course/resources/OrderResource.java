package com.richard.course.resources;

import com.richard.course.entities.Order;
import com.richard.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//A classe vira um recurso web REST
@RestController
//precisa de um nome!
@RequestMapping(value = "/orders") // "rota"
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping //GET
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list); //diz que vai retornar 200 (OK) e que o corpo enviado sera a minha instancia
    }

    @GetMapping(value = "/{id}") //url params
    //@PathVariable serve para pegar a variavel do url params
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = service.findById(id); //pega da classe service onde vai estar todos os tipos de execucoes e buscas
        return ResponseEntity.ok().body(obj); //200, {Corpo}
    }

}
