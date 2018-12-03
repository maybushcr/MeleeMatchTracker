package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class PlayerWinRateByPlayer {

    private Integer playerId;
    private Integer opponentPlayerId;
    private Double winPercentage;

    public PlayerWinRateByPlayer(){}

    public PlayerWinRateByPlayer(Integer playerId, Integer opponentPlayerId, Double winPercentage) {
        this.playerId = playerId;
        this.opponentPlayerId = opponentPlayerId;
        this.winPercentage = winPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerWinRateByPlayer that = (PlayerWinRateByPlayer) o;
        return Objects.equals(playerId, that.playerId) &&
                Objects.equals(opponentPlayerId, that.opponentPlayerId) &&
                Objects.equals(winPercentage, that.winPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, opponentPlayerId, winPercentage);
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getOpponentPlayerId() {
        return opponentPlayerId;
    }

    public void setOpponentPlayerId(Integer opponentPlayerId) {
        this.opponentPlayerId = opponentPlayerId;
    }

    public Double getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(Double winPercentage) {
        this.winPercentage = winPercentage;
    }
}
