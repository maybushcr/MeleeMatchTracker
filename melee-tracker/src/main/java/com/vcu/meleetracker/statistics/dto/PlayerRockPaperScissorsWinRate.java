package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class PlayerRockPaperScissorsWinRate {

    private Integer playerId;
    private Double winPercentage;

    public PlayerRockPaperScissorsWinRate(){}

    public PlayerRockPaperScissorsWinRate(Integer playerId, Double winPercentage) {
        this.playerId = playerId;
        this.winPercentage = winPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerRockPaperScissorsWinRate that = (PlayerRockPaperScissorsWinRate) o;
        return Objects.equals(playerId, that.playerId) &&
                Objects.equals(winPercentage, that.winPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, winPercentage);
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Double getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(Double winPercentage) {
        this.winPercentage = winPercentage;
    }
}
