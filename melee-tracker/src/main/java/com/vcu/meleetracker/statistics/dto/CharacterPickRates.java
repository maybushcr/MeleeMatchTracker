package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class CharacterPickRates {
        private int playerId;
        private int charcterId;
        private int gamesPlayed;

    public CharacterPickRates(){}

    public CharacterPickRates(int playerId, int charcterId, int gamesPlayed) {
        this.playerId = playerId;
        this.charcterId = charcterId;
        this.gamesPlayed = gamesPlayed;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getCharcterId() {
        return charcterId;
    }

    public void setCharcterId(int charcterId) {
        this.charcterId = charcterId;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterPickRates)) return false;
        CharacterPickRates that = (CharacterPickRates) o;
        return playerId == that.playerId &&
                charcterId == that.charcterId &&
                gamesPlayed == that.gamesPlayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, charcterId, gamesPlayed);
    }
}
