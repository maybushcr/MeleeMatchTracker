package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class PlayerWinRateByCharacter {

    private Integer playerId;
    private Integer characterId;
    private Integer winPercentage;

    public PlayerWinRateByCharacter(){}

    public PlayerWinRateByCharacter(Integer playerId, Integer characterId, Integer winPercentage) {
        this.playerId = playerId;
        this.characterId = characterId;
        this.winPercentage = winPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerWinRateByCharacter that = (PlayerWinRateByCharacter) o;
        return Objects.equals(playerId, that.playerId) &&
                Objects.equals(characterId, that.characterId) &&
                Objects.equals(winPercentage, that.winPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, characterId, winPercentage);
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Integer getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(Integer winPercentage) {
        this.winPercentage = winPercentage;
    }
}
