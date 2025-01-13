package com.pokeapi.pokemon_api.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.pokeapi.pokemon_api.dto.TypeDTO;
import com.pokeapi.pokemon_api.model.Type;
import com.pokeapi.pokemon_api.repository.TypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TypeServiceTest {

    @MockBean
    private TypeRepository typeRepository;

    @Autowired
    private TypeService typeService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testCreateType() {
        Type type = new Type("Fire");
        when(typeRepository.save(any(Type.class))).thenReturn(type);

        TypeDTO typeDTO = new TypeDTO("Fire");
        Type result = typeService.save(typeDTO);

        assertNotNull(result);
        assertEquals("Fire", result.getName());
        verify(typeRepository, times(1)).save(any(Type.class));
    }
}