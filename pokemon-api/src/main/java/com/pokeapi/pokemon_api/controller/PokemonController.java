package com.pokeapi.pokemon_api.controller;

import com.pokeapi.pokemon_api.model.Pokemon;
import com.pokeapi.pokemon_api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    private final PokemonService service;

    @Autowired
    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/pokemons")
    public List<Pokemon> getPokemons() {
        return service.getAllPokemon();
    }
}