package com.vcu.meleetracker.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="set",cascade = CascadeType.ALL)
    private List<Match> matches = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="set",cascade = CascadeType.ALL)
    private List<RockPaperScissors> rockPaperScissors = new ArrayList<>();

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
