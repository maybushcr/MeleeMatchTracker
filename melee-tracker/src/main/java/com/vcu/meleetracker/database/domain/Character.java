package com.vcu.meleetracker.database.domain;

import javax.persistence.*;

@Entity
@Table(name="CHARACTERS")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "character_id")
    private Integer characterId;

    @Column(name = "character_name")
    private String name;

    @Column(name = "character_weight")
    private Integer weight;

    public Character(){}

    public Character(String name, Integer weight){
        this.name = name;
        this.weight = weight;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
