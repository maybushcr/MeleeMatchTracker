package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class CharacterWinRateByStage {

    private Integer characterId;
    private Integer stageId;
    private Double winPercentage;

    public CharacterWinRateByStage(){}

    public CharacterWinRateByStage(Integer characterId, Integer stageId, Double winPercentage) {
        this.characterId = characterId;
        this.stageId = stageId;
        this.winPercentage = winPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterWinRateByStage that = (CharacterWinRateByStage) o;
        return Objects.equals(characterId, that.characterId) &&
                Objects.equals(stageId, that.stageId) &&
                Objects.equals(winPercentage, that.winPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, stageId, winPercentage);
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
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
