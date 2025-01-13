package com.pokeapi.pokemon_api.service;

import com.pokeapi.pokemon_api.dto.TypeDTO;
import com.pokeapi.pokemon_api.model.Type;
import com.pokeapi.pokemon_api.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getAllType() {
        return typeRepository.findAll();
    }

    public Type save(TypeDTO typedto) {
        Type type = new Type(typedto.getName());
        return this.typeRepository.save(type);
    }
}
