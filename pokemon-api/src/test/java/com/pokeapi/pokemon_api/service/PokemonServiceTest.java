package com.pokeapi.pokemon_api.service;

import com.pokeapi.pokemon_api.dto.PokemonDTO;
import com.pokeapi.pokemon_api.dto.TypeDTO;
import com.pokeapi.pokemon_api.model.Pokemon;
import com.pokeapi.pokemon_api.model.Type;
import com.pokeapi.pokemon_api.repository.PokemonRepository;
import com.pokeapi.pokemon_api.repository.TypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {
    @Mock
    private PokemonRepository pokemonRepository;

    @Mock
    private TypeRepository typeRepository;

    @InjectMocks
    private PokemonService pokemonService;

    @Test
    void testGetAllPokemon() {
        Type type = new Type("Electrique");
        Pokemon pokemon1 = new Pokemon("Salamèche", 1, 120, 80, type);
        Pokemon pokemon2 = new Pokemon("Bulbizarre", 1, 120, 80, type);
        when(pokemonRepository.findAll()).thenReturn(List.of(pokemon1, pokemon2));

        List<Pokemon> result = pokemonService.getAllPokemon();

        assertNotNull(result);
        assertEquals(List.of(pokemon1, pokemon2), result);
    }

    @Test
    void testSavePokemon() {
        Type type = new Type("Eau");
        Pokemon pokemon = new Pokemon("Carapuce", 1, 120, 80, type);
        PokemonDTO pokemonDTO = new PokemonDTO("Carapuce", 1, 120, 80, type);

        when(typeRepository.findById(any())).thenReturn(Optional.of(type));
        when(pokemonRepository.save(any(Pokemon.class))).thenReturn(pokemon);

        Pokemon result = pokemonService.save(pokemonDTO);

        assertEquals(pokemon, result);
    }
}