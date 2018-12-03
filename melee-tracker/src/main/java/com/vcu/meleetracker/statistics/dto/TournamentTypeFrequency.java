package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class TournamentTypeFrequency {

    private Integer tournament_type_id;
    private Integer count;

    public TournamentTypeFrequency(){}

    public TournamentTypeFrequency(Integer tournament_type_id, Integer count) {
        this.tournament_type_id = tournament_type_id;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentTypeFrequency that = (TournamentTypeFrequency) o;
        return Objects.equals(tournament_type_id, that.tournament_type_id) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tournament_type_id, count);
    }

    public Integer getTournament_type_id() {
        return tournament_type_id;
    }

    public void setTournament_type_id(Integer tournament_type_id) {
        this.tournament_type_id = tournament_type_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
