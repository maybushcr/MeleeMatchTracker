package com.vcu.meleetracker.domain;

import javax.persistence.*;

@Entity
@Table(name="TOURNAMENT_TYPES")
public class TournamentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tournament_type_id")
    private Integer tournamentTypeId;

    @Column(name = "tournament_type")
    private String tournamentType;

    public TournamentType(){}

    public TournamentType(String tournamentType){
        this.tournamentType = tournamentType;
    }

    public Integer getTournamentTypeId() {
        return tournamentTypeId;
    }

    public void setTournamentTypeId(Integer tournamentTypeId) {
        this.tournamentTypeId = tournamentTypeId;
    }

    public String getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(String tournamentType) {
        this.tournamentType = tournamentType;
    }
}
