package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class PlayerWinRateByStage {

    private Integer playerId;
    private Integer stageId;
    private Double winPercentage;

    public PlayerWinRateByStage(){}

    public PlayerWinRateByStage(Integer playerId, Integer stageId, Double winPercentage) {
        this.playerId = playerId;
        this.stageId = stageId;
        this.winPercentage = winPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerWinRateByStage that = (PlayerWinRateByStage) o;
        return Objects.equals(playerId, that.playerId) &&
                Objects.equals(stageId, that.stageId) &&
                Objects.equals(winPercentage, that.winPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, stageId, winPercentage);
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public Double getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(Double winPercentage) {
        this.winPercentage = winPercentage;
    }
}
