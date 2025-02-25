package com.pokeapi.pokemon_api.controller;

import com.pokeapi.pokemon_api.dto.PokemonDTO;
import com.pokeapi.pokemon_api.model.Pokemon;
import com.pokeapi.pokemon_api.service.PokemonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Pokemon request", description = "Pokemon request API")
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

    @PostMapping("/pokemon")
    public Pokemon savePokemon(@RequestBody PokemonDTO pokemon) {
        return service.save(pokemon);
    }
}