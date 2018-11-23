package com.vcu.meleetracker.domain;

import javax.persistence.*;

@Entity
@Table(name="PLAYERS")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "player_name")
    private String name;

    @Column(name = "player_alias")
    private String alias;

    public Player(){}

    public Player(String name, String alias){
        this.name = name;
        this.alias = alias;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
