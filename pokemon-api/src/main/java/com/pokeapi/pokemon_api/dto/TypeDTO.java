package com.pokeapi.pokemon_api.dto;

public class TypeDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected TypeDTO() {}

    public TypeDTO(String name) {
        this.name = name;
    }
}
