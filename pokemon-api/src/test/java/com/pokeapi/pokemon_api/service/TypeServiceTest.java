package com.pokeapi.pokemon_api.service;

import com.pokeapi.pokemon_api.dto.TypeDTO;
import com.pokeapi.pokemon_api.model.Type;
import com.pokeapi.pokemon_api.repository.TypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TypeServiceTest {
    @Mock
    private TypeRepository typeRepository;

    @InjectMocks
    private TypeService typeService;

    @Test
    void testGetAllType() {
        Type type1 = new Type("Electrique");
        Type type2 = new Type("Feu");
        when(typeRepository.findAll()).thenReturn(List.of(type1, type2));

        List<Type> result = typeService.getAllType();

        assertNotNull(result);
        assertEquals(List.of(type1, type2), result);
    }

    @Test
    void testSaveType() {
        TypeDTO typeDTO = new TypeDTO("Eau");
        Type type = new Type(typeDTO.getName());

        when(typeRepository.save(any(Type.class))).thenReturn(type);

        Type result = typeService.save(typeDTO);

        assertEquals(type, result);
    }
}