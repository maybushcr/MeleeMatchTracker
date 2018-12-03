package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class CharacterPickRate {
    private Integer playerId;
    private Integer characterId;
    private Integer gamesPlayed;

    public CharacterPickRate(){}

    public CharacterPickRate(Integer playerId, Integer characterId, Integer gamesPlayed) {
        this.playerId = playerId;
        this.characterId = characterId;
        this.gamesPlayed = gamesPlayed;
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

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterPickRate)) return false;
        CharacterPickRate that = (CharacterPickRate) o;
        return playerId == that.playerId &&
                characterId == that.characterId &&
                gamesPlayed == that.gamesPlayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, characterId, gamesPlayed);
    }
}
