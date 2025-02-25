package com.pokeapi.pokemon_api.service;

import com.pokeapi.pokemon_api.dto.PokemonDTO;
import com.pokeapi.pokemon_api.model.Pokemon;
import com.pokeapi.pokemon_api.model.Type;
import com.pokeapi.pokemon_api.repository.PokemonRepository;
import com.pokeapi.pokemon_api.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final TypeRepository typeRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, TypeRepository typeRepository) {
        this.pokemonRepository = pokemonRepository;
        this.typeRepository = typeRepository;
    }

    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public Pokemon save(PokemonDTO pokemonDTO) {
        if (pokemonDTO == null) {
            throw new IllegalArgumentException("Pokemon cannot be null");
        }

        Optional<Type> typeOptional = typeRepository.findById(pokemonDTO.getType().getId());
        if (typeOptional.isPresent()) {
            Pokemon pokemon = new Pokemon(
                    pokemonDTO.getName(),
                    pokemonDTO.getBase_experience(),
                    pokemonDTO.getWeight(),
                    pokemonDTO.getHeight(),
                    typeOptional.get()
            );
            return pokemonRepository.save(pokemon);
        } else {
            throw new IllegalArgumentException("Type not found");
        }
    }
}
