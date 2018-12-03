package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class PlayerWinRateByCharacter {

    private Integer characterId;
    private Integer opponentCharacterId;
    private Double winPercentage;

    public PlayerWinRateByCharacter(){}

    public PlayerWinRateByCharacter(Integer characterId, Integer opponentCharacterId, Double winPercentage) {
        this.characterId = characterId;
        this.opponentCharacterId = opponentCharacterId;
        this.winPercentage = winPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerWinRateByCharacter that = (PlayerWinRateByCharacter) o;
        return Objects.equals(characterId, that.characterId) &&
                Objects.equals(opponentCharacterId, that.opponentCharacterId) &&
                Objects.equals(winPercentage, that.winPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, opponentCharacterId, winPercentage);
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Integer getOpponentCharacterId() {
        return opponentCharacterId;
    }

    public void setOpponentCharacterId(Integer opponentCharacterId) {
        this.opponentCharacterId = opponentCharacterId;
    }

    public Double getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(Double winPercentage) {
        this.winPercentage = winPercentage;
    }
}
