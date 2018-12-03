package com.vcu.meleetracker.statistics.dto;

import java.util.Objects;

public class PVPWinRates {

    private String participantName;
    private double winPercentage;

    public PVPWinRates(){}

    public PVPWinRates(String participantName, double winPercentage) {
        this.participantName = participantName;
        this.winPercentage = winPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PVPWinRates that = (PVPWinRates) o;
        return  winPercentage == that.winPercentage &&
                Objects.equals(participantName, that.participantName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantName, winPercentage);
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public double getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(double winPercentage) {
        this.winPercentage = winPercentage;
    }
}
