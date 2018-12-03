package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class CharacterWinRate {

    private Integer characterId;
    private Double winPercentage;

    public CharacterWinRate(){}

    public CharacterWinRate(Integer characterId, Double winPercentage) {
        this.characterId = characterId;
        this.winPercentage = winPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterWinRate that = (CharacterWinRate) o;
        return Objects.equals(characterId, that.characterId) &&
                Objects.equals(winPercentage, that.winPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, winPercentage);
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Double getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(Double winPercentage) {
        this.winPercentage = winPercentage;
    }
}
