package com.pokeapi.pokemon_api.controller;

import com.pokeapi.pokemon_api.model.Type;
import com.pokeapi.pokemon_api.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
