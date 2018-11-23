package com.vcu.meleetracker.domain;

import javax.persistence.*;

@Entity
@Table(name="SETS")
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "set_id")
    private Integer setId;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public Set(){}

    public Set(Tournament tournament){
        this.tournament = tournament;
    }

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
