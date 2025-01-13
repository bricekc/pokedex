package com.pokeapi.pokemon_api.repository;

import com.pokeapi.pokemon_api.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TypeRepository extends JpaRepository<Type, UUID> {
}
