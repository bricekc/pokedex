package com.pokeapi.pokemon_api.repository;

import com.pokeapi.pokemon_api.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    List<Pokemon> findAll();
}
