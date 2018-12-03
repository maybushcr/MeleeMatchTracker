package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class CharacterPickRate {

    private Integer characterId;
    private Integer gamesPlayed;

    public CharacterPickRate(){}

    public CharacterPickRate(Integer characterId, Integer gamesPlayed) {
        this.characterId = characterId;
        this.gamesPlayed = gamesPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterPickRate)) return false;
        CharacterPickRate that = (CharacterPickRate) o;
        return characterId == that.characterId &&
                gamesPlayed == that.gamesPlayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, gamesPlayed);
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
