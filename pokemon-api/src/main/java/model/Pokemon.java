package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer base_experience;

    private Integer height;

    private Integer weight;

    protected Pokemon() {}

    public Pokemon(String name, Integer base_experience, Integer height, Integer weight) {
        this.name = name;
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;
    }

    public Long getId() {
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
}
