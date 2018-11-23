package com.vcu.meleetracker.domain;

import javax.persistence.*;

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
