package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class CharacterPickRateByPlayer {

    private Integer playerId;
    private Integer characterId;
    private Integer gamesPlayed;

    public CharacterPickRateByPlayer(){}

    public CharacterPickRateByPlayer(Integer playerId, Integer characterId, Integer gamesPlayed) {
        this.playerId = playerId;
        this.characterId = characterId;
        this.gamesPlayed = gamesPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterPickRateByPlayer that = (CharacterPickRateByPlayer) o;
        return Objects.equals(playerId, that.playerId) &&
                Objects.equals(characterId, that.characterId) &&
                Objects.equals(gamesPlayed, that.gamesPlayed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, characterId, gamesPlayed);
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
}
