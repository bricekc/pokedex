package com.pokeapi.pokemon_api.dto;

import com.pokeapi.pokemon_api.model.Type;

public class PokemonDTO {
    private String name;

    private int base_experience;

    private int height;

    private int weight;

    private Type type;

    protected PokemonDTO() {}

    public PokemonDTO(String name, int base_experience, int height, int weight, Type type) {
        this.name = name;
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
