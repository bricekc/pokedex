package com.pokeapi.pokemon_api.controller;

import com.pokeapi.pokemon_api.dto.TypeDTO;
import com.pokeapi.pokemon_api.model.Type;
import com.pokeapi.pokemon_api.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TypeController {

    private final TypeService service;

    @Autowired
    public TypeController(TypeService service) {
        this.service = service;
    }

    @GetMapping("/types")
    public List<Type> getTypes() {
        return this.service.getAllType();
    }

    @PostMapping("/types")
    public ResponseEntity<Type> SaveTypes(@RequestBody TypeDTO typeDTO) {
        Type type = service.save(typeDTO);
        return new ResponseEntity<>(type, HttpStatus.CREATED);
    }

}
