package com.vcu.meleetracker.database.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TOURNAMENTS")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tournament_id")
    private Integer tournamentId;

    @ManyToOne
    @JoinColumn(name = "tournament_type_id")
    private TournamentType tournamentType;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="tournament",cascade = CascadeType.ALL)
    private List<Set> sets = new ArrayList<>();

    public Tournament(){}

    public Tournament(TournamentType turnamentType){
        this.tournamentType = tournamentType;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public TournamentType getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(TournamentType tournamentType) {
        this.tournamentType = tournamentType;
    }
}
