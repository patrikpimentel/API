package com.first.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.first.api.entity.model.User;
import com.first.api.service.BibliotecaService;


@RestController
@RequestMapping("/api")
public class Controller {
    
    @Autowired
    private BibliotecaService biblioteca;
    

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserId(@PathVariable Long id){
	var user = biblioteca.findByUserID(id);
	return ResponseEntity.ok(user);
    }
    
    @GetMapping()
    public ResponseEntity<List<User>> findAllUser(){
	var users = biblioteca.findAllUser();
	return ResponseEntity.ok(users);
    }
    
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
	var userCreate = biblioteca.createUser(user);
	URI location = ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("/{id}").
		buildAndExpand(userCreate.getId()).
		toUri();
	
	return ResponseEntity.created(location).
		body(userCreate);
    }
}
