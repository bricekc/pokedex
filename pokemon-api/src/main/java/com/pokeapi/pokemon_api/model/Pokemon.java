package com.pokeapi.pokemon_api.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    private String name;

    private Integer base_experience;

    private Integer height;

    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    protected Pokemon() {}

    public Pokemon(String name, Integer base_experience, Integer height, Integer weight, Type type) {
        this.name = name;
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
