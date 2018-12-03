package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class PlayerMatchesPlayed {

    private Integer playerId;
    private Integer gamesPlayed;

    public PlayerMatchesPlayed(){}

    public PlayerMatchesPlayed(Integer playerId, Integer gamesPlayed) {
        this.playerId = playerId;
        this.gamesPlayed = gamesPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerMatchesPlayed that = (PlayerMatchesPlayed) o;
        return Objects.equals(playerId, that.playerId) &&
                Objects.equals(gamesPlayed, that.gamesPlayed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, gamesPlayed);
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }
}
