package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class TournamentTypeFrequency {

    private Integer tournamentTypeId;
    private Integer count;

    public TournamentTypeFrequency(){}

    public TournamentTypeFrequency(Integer tournamentTypeId, Integer count) {
        this.tournamentTypeId = tournamentTypeId;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentTypeFrequency that = (TournamentTypeFrequency) o;
        return Objects.equals(tournamentTypeId, that.tournamentTypeId) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tournamentTypeId, count);
    }

    public Integer getTournamentTypeId() {
        return tournamentTypeId;
    }

    public void setTournamentTypeId(Integer tournamentTypeId) {
        this.tournamentTypeId = tournamentTypeId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
