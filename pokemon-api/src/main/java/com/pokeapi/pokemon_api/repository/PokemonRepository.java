package com.pokeapi.pokemon_api.repository;

import com.pokeapi.pokemon_api.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PokemonRepository extends JpaRepository<Pokemon, UUID> {
}
