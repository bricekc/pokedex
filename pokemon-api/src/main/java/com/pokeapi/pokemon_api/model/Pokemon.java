package com.pokeapi.pokemon_api.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    private String name;

    private int base_experience;

    private int height;

    private int weight;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    protected Pokemon() {}

    public Pokemon(String name, int base_experience, int height, int weight, Type type) {
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

    public void setHeight(int height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
